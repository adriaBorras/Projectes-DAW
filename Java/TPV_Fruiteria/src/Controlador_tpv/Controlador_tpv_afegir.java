/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_tpv;

import Model_tpv.Categoria;
import Model_tpv.Producte;
import Model_tpv.Utils;
import Persistencia.CategoriaDAO;
import Persistencia.ProducteDAO;
import Vista_tpv.Vista_tpv_afegir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author borras
 */
public class Controlador_tpv_afegir implements ActionListener {

    private Vista_tpv_afegir vista_tpv_afegir;
    //private DefaultTableModel tm;

    //Patró Singleton
    private static Controlador_tpv_afegir instancia = null;

    private Controlador_tpv_afegir() {

        vista_tpv_afegir = new Vista_tpv_afegir();
        vista_tpv_afegir.getjButtonAfegirProducte().addActionListener(this);

    }

    //Patró Singleton
    public static Controlador_tpv_afegir getInstance() {
        if (instancia == null) {
            instancia = new Controlador_tpv_afegir();
        }
        return instancia;
    }

    public void run() throws SQLException {

        fillComboboxes();
        vista_tpv_afegir.setVisible(true);
        vista_tpv_afegir.setTitle("TPV Fruiteria - Afegir Producte ");
        vista_tpv_afegir.setLocationRelativeTo(null);

        // al tancar la finestra "Afegir producte" mostra la finestra tpv
        vista_tpv_afegir.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                try {
//                    Controlador_tpv.getInstance().
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
            }
        });

    }

    public void fillComboboxes() {
        //Categoria
        ArrayList<Categoria> llistaCategories = new ArrayList<>();
        try {
            llistaCategories = CategoriaDAO.getInstance().getCategories();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Categoria c : llistaCategories) {
            vista_tpv_afegir.getjComboBoxCategoria().addItem(c.getNom());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista_tpv_afegir.getjButtonAfegirProducte()) {

            //comprovem camps i recollim les dades entrades a variables
            //variable per saber si tots els camps son correctes.
            boolean valid = true;

            // nom 
            String nom = vista_tpv_afegir.getjTextFieldNomProducte().getText().trim();
            if (nom.isBlank()) {
                vista_tpv_afegir.getjLabelNomError().setText("El camp esta buit!");
                valid = false;
            } else if (!Utils.comprovaNom(nom)) {
                vista_tpv_afegir.getjLabelNomError().setText("Lletres i numeros!");
                valid = false;
            } else {
                vista_tpv_afegir.getjLabelNomError().setText("");
            }

            // preu
            String preuString = vista_tpv_afegir.getjTextFieldPreu().getText().trim();
            double preu = 0;
            if (preuString.isBlank()) {
                vista_tpv_afegir.getjLabelPreuError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    preu = Double.parseDouble(preuString);
                    vista_tpv_afegir.getjLabelPreuError().setText("");
                } catch (Exception e) { // Exception 
                    vista_tpv_afegir.getjLabelPreuError().setText("Preu no valid!");
                    valid = false;
                }
            }
            //stock
            String stockText = vista_tpv_afegir.getjTextFieldStock().getText().trim();
            int stock = 0;
            if (stockText.isBlank()) {
                vista_tpv_afegir.getjLabelStockError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    stock = Integer.parseInt(stockText);
                    vista_tpv_afegir.getjLabelStockError().setText("");
                } catch (NumberFormatException e) {
                    vista_tpv_afegir.getjLabelStockError().setText("Stock no valid!");
                    System.out.println(e);
                    valid = false;
                }
            }
            //seccio
            String seccioString = vista_tpv_afegir.getjTextFieldSeccio().getText().trim();
            int seccio = 0;
            if (seccioString.isBlank()) {
                vista_tpv_afegir.getjLabelSeccioError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    seccio = Integer.parseInt(seccioString);
                    if (seccio <= 13) {
                        vista_tpv_afegir.getjLabelSeccioError().setText("ok");
                    } else {
                        vista_tpv_afegir.getjLabelSeccioError().setText("Maxim 13!");
                        valid = false;
                    }
                } catch (NumberFormatException e) {
                    vista_tpv_afegir.getjLabelSeccioError().setText("Seccio no valida!");
                    valid = false;
                }
            }
            //tipusPreu
            String tipusPreu = ""; //unitari,pes/Kg,pes/g,paquet.
            if (vista_tpv_afegir.getjRadioButtonUnitari().isSelected()) {
                tipusPreu = "unitari";
            } else if (vista_tpv_afegir.getjRadioButtonPesK().isSelected()) {
                tipusPreu = "pes/Kg";
            } else if (vista_tpv_afegir.getjRadioButtonPaquet().isSelected()) {
                tipusPreu = "paquet";
            } else if (vista_tpv_afegir.getjRadioButtonPesG().isSelected()) {
                tipusPreu = "pes/g";
            } else {
                vista_tpv_afegir.getjLabelTipusPreuError().setText("Tria una opcio!");
                //JOptionPane.showMessageDialog(vista_tpv_afegir, "Tria una opcio!", "ERROR", JOptionPane.WARNING_MESSAGE);
                valid = false;
            }
            //si tots els camps son correctes...
            if (valid == true) {
                System.out.println("Boto afegir premut");
                Producte p = new Producte();

                //Recollim categoria
                Categoria categoria = null;
                String nomCategoria = vista_tpv_afegir.getjComboBoxCategoria().getSelectedItem().toString().toLowerCase();
                ArrayList<Categoria> llistaCategories = new ArrayList<>();
                try {
                    llistaCategories = CategoriaDAO.getInstance().getCategories();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                for (Categoria c : llistaCategories) {
                    if (nomCategoria.equals(c.getNom().toLowerCase())) {
                        categoria = c;
                    }
                }
                boolean oferta = vista_tpv_afegir.getjCheckBoxTeOferta().isSelected();

                p.setNom(nom);
                p.setCategoria(categoria);
                p.setPreu(preu);
                p.setTipusPreu(tipusPreu);
                p.setStock(stock);
                p.setOferta(oferta);
                p.setSeccio(seccio);

                try {
                    if (ProducteDAO.getInstance().afegirProducte(p)) {
                        Controlador_tpv.getInstance().carregaSlider();
                        Controlador_tpv.getInstance().actualitzaTaulaOrdenada(ProducteDAO.getInstance().getProductes("codi", "asc"));
                        JOptionPane.showMessageDialog(vista_tpv_afegir, "Producte afegit!", "INFO_MESSAGE", JOptionPane.INFORMATION_MESSAGE); //tambe pausa l'accio fins que es tanca la finestra!!
                    } else {
                        JOptionPane.showMessageDialog(vista_tpv_afegir, "Producte no afegit!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    //System.out.println("error "+ ex);
                    JOptionPane.showMessageDialog(vista_tpv_afegir, "Ja existeix un Producte amb aquets nom!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(vista_tpv_afegir, "Error al afegir producte \n Comprova els camps!", "ERROR", JOptionPane.WARNING_MESSAGE);
                System.out.println("Almenys un camp esta buit!");
                //ara es redundant, fora.
//                if (vista_tpv_afegir.getjTextFieldNomProducte().getText().isBlank()) {
//                    vista_tpv_afegir.getjLabelNomError().setText("El camp esta buit!");
//                } else if (vista_tpv_afegir.getjTextFieldPreu().getText().isBlank()) {
//                    vista_tpv_afegir.getjLabelPreuError().setText("El camp esta buit!");
//                } else if (vista_tpv_afegir.getjTextFieldSeccio().getText().isBlank()) {
//                    vista_tpv_afegir.getjLabelSeccioError().setText("El camp esta buit!");
//                } else if (vista_tpv_afegir.getjTextFieldStock().getText().isBlank()) {
//                    vista_tpv_afegir.getjLabelStockError().setText("El camp esta buit!");
//                }

                //intent anterior
                //comprovem que no tinguem camps en blanc
//            if (!vista_tpv_afegir.getjTextFieldNomProducte().getText().isBlank()
//                    && !vista_tpv_afegir.getjTextFieldPreu().getText().isBlank()
//                    && !vista_tpv_afegir.getjTextFieldStock().getText().isBlank()
//                    && (vista_tpv_afegir.getjRadioButtonPaquet().isSelected() || vista_tpv_afegir.getjRadioButtonPesK().isSelected() || vista_tpv_afegir.getjRadioButtonPesG().isSelected() || vista_tpv_afegir.getjRadioButtonUnitari().isSelected())
//                    && !vista_tpv_afegir.getjTextFieldSeccio().getText().isBlank()) {
//
//                System.out.println("Boto Afegir premut");
//                Producte p = new Producte();
//                //recollim dades del formulari                
//                //Recollim nom
//                String nom = String.valueOf(vista_tpv_afegir.getjTextFieldNomProducte().getText().trim());
//
//                if (!Utils.comprovaNom(nom)) {
//                    vista_tpv_afegir.getjLabelNomError().setText("Nomes lletres!.");
//                    return; // meeec!!! no sirve! no segeix comprovant altres camps!
//                } else {
//                    vista_tpv_afegir.getjLabelNomError().setText("");
//                }
//
//                //Recollim categoria
//                Categoria categoria = null;
//                String nomCategoria = vista_tpv_afegir.getjComboBoxCategoria().getSelectedItem().toString().toLowerCase();
//                ArrayList<Categoria> llistaCategories = new ArrayList<>();
//                try {
//                    llistaCategories = CategoriaDAO.getInstance().getCategories();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//                for (Categoria c : llistaCategories) {
//                    if (nomCategoria.equals(c.getNom().toLowerCase())) {
//                        categoria = c;
//                    }
//                }
//                //Recollim preu
//                double preu = Double.parseDouble(vista_tpv_afegir.getjTextFieldPreu().getText().trim());
//                //Recollim tipusPreu
//                String tipusPreu = ""; //unitari,pes/Kg,pes/g,paquet.
//                if (vista_tpv_afegir.getjRadioButtonUnitari().isSelected()) {
//                    tipusPreu = "unitari";
//                } else if (vista_tpv_afegir.getjRadioButtonPesK().isSelected()) {
//                    tipusPreu = "pes/Kg";
//                } else if (vista_tpv_afegir.getjRadioButtonPaquet().isSelected()) {
//                    tipusPreu = "paquet";
//                } else if (vista_tpv_afegir.getjRadioButtonPesG().isSelected()) {
//                    tipusPreu = "pes/g";
//                }
//                //Recollim stock,oferta,seccio
//                int stock = Integer.parseInt(vista_tpv_afegir.getjTextFieldStock().getText().trim());
//                boolean oferta = vista_tpv_afegir.getjCheckBoxTeOferta().isSelected();
//                int seccio = Integer.parseInt(vista_tpv_afegir.getjTextFieldSeccio().getText().trim());
//
//                p.setNom(nom);
//                p.setCategoria(categoria);
//                p.setPreu(preu);
//                p.setTipusPreu(tipusPreu);
//                p.setStock(stock);
//                p.setOferta(oferta);
//                p.setSeccio(seccio);
//
//                try {
//                    if (ProducteDAO.getInstance().afegirProducte(p)) {
//                        JOptionPane.showMessageDialog(vista_tpv_afegir, "Producte afegit!", "INFO_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(vista_tpv_afegir, "no afegt", "ERROR", JOptionPane.WARNING_MESSAGE);
//                    }
//                } catch (SQLException ex) {
//                    //System.out.println("error "+ ex);
//                    JOptionPane.showMessageDialog(vista_tpv_afegir, "Ja existeix un Producte amb aquets nom!", "ERROR", JOptionPane.WARNING_MESSAGE);
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(vista_tpv_afegir, "Algun camp necessari esta buit!", "ERROR", JOptionPane.WARNING_MESSAGE);
//                System.out.println("Almenys un camp esta buit!");
//                if (vista_tpv_afegir.getjTextFieldNomProducte().getText().isBlank()) {
//                    vista_tpv_afegir.getjLabelNomError().setText("El camp esta buit!");
//                }
//            }
            }

        }

    }
}
