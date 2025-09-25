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
import Vista_tpv.Vista_tpv_modificar;
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
public class Controlador_tpv_modificar implements ActionListener {
    
    private Vista_tpv_modificar vista_tpv_modificar;
    //private DefaultTableModel tm;

    //Patró Singleton
    private static Controlador_tpv_modificar instancia = null;
    
    private Controlador_tpv_modificar() {
        
        vista_tpv_modificar = new Vista_tpv_modificar();
        vista_tpv_modificar.getjButtonModificarProducte().addActionListener(this);
        
    }

    //Patró Singleton
    public static Controlador_tpv_modificar getInstance() {
        if (instancia == null) {
            instancia = new Controlador_tpv_modificar();
        }
        return instancia;
    }
    
    public void run(int codi, String nom, String categoria, double preu, String tipusPreu, int stock, boolean oferta, int seccio) throws SQLException {
        
        fillComboboxes();
        vista_tpv_modificar.setVisible(true);
        vista_tpv_modificar.setTitle("TPV Fruiteria - Modificar Producte ");
        vista_tpv_modificar.setLocationRelativeTo(null);
        
        vista_tpv_modificar.getjTextFieldNomProducte().setText(nom);        
        vista_tpv_modificar.getjTextFieldPreu().setText(String.valueOf(preu));
        vista_tpv_modificar.getjTextFieldStock().setText(String.valueOf(stock));
        vista_tpv_modificar.getjTextFieldSeccio().setText(String.valueOf(seccio));
        vista_tpv_modificar.getjComboBoxCategoria().setSelectedItem(categoria);
        vista_tpv_modificar.getjCheckBoxTeOferta().setSelected(oferta);
        tipusPreu = tipusPreu.toLowerCase();
        
        switch (tipusPreu) {
            case "unitari":
                vista_tpv_modificar.getjRadioButtonUnitari().setSelected(true);
                break;
            case "paquet":
                vista_tpv_modificar.getjRadioButtonPaquet().setSelected(true);
                break;
            case "pes/kg":
                vista_tpv_modificar.getjRadioButtonPesK().setSelected(true);
                break;
                case "pes/g":
                vista_tpv_modificar.getjRadioButtonPesG().setSelected(true);
                break;
            default:
                throw new AssertionError();
        }

        // al tancar la finestra "Afegir producte" mostra la finestra tpv
        vista_tpv_modificar.addWindowListener(new WindowAdapter() {
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
            vista_tpv_modificar.getjComboBoxCategoria().addItem(c.getNom());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == vista_tpv_modificar.getjButtonModificarProducte()) {

            //comprovem camps i recollim les dades entrades a variables
            //variable per saber si tots els camps son correctes.
            boolean valid = true;

            // nom 
            String nom = vista_tpv_modificar.getjTextFieldNomProducte().getText().trim();
            if (nom.isBlank()) {
                vista_tpv_modificar.getjLabelNomError().setText("El camp esta buit!");
                valid = false;
            } else if (!Utils.comprovaNom(nom)) {
                vista_tpv_modificar.getjLabelNomError().setText("Lletres i numeros!");
                valid = false;
            } else {
                vista_tpv_modificar.getjLabelNomError().setText("");
            }

            // preu
            String preuString = vista_tpv_modificar.getjTextFieldPreu().getText().trim();
            double preu = 0;
            if (preuString.isBlank()) {
                vista_tpv_modificar.getjLabelPreuError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    preu = Double.parseDouble(preuString);
                    vista_tpv_modificar.getjLabelPreuError().setText("");
                } catch (Exception e) { // Exception 
                    vista_tpv_modificar.getjLabelPreuError().setText("Preu no valid!");
                    valid = false;
                }
            }
            //stock
            String stockText = vista_tpv_modificar.getjTextFieldStock().getText().trim();
            int stock = 0;
            if (stockText.isBlank()) {
                vista_tpv_modificar.getjLabelStockError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    stock = Integer.parseInt(stockText);
                    vista_tpv_modificar.getjLabelStockError().setText("");
                } catch (NumberFormatException e) {
                    vista_tpv_modificar.getjLabelStockError().setText("Stock no valid!");
                    System.out.println(e);
                    valid = false;
                }
            }
            //seccio
            String seccioString = vista_tpv_modificar.getjTextFieldSeccio().getText().trim();
            int seccio = 0;
            if (seccioString.isBlank()) {
                vista_tpv_modificar.getjLabelSeccioError().setText("El camp esta buit!");
                valid = false;
            } else {
                try {
                    seccio = Integer.parseInt(seccioString);
                    if (seccio <= 13) {
                        vista_tpv_modificar.getjLabelSeccioError().setText("ok");
                    } else {
                        vista_tpv_modificar.getjLabelSeccioError().setText("Maxim 13!");
                        valid = false;
                    }
                } catch (NumberFormatException e) {
                    vista_tpv_modificar.getjLabelSeccioError().setText("Seccio no valida!");
                    valid = false;
                }
            }
            //tipusPreu
            String tipusPreu = ""; //unitari,pes/Kg,pes/g,paquet.
            if (vista_tpv_modificar.getjRadioButtonUnitari().isSelected()) {
                tipusPreu = "unitari";
            } else if (vista_tpv_modificar.getjRadioButtonPesK().isSelected()) {
                tipusPreu = "pes/Kg";
            } else if (vista_tpv_modificar.getjRadioButtonPaquet().isSelected()) {
                tipusPreu = "paquet";
            } else if (vista_tpv_modificar.getjRadioButtonPesG().isSelected()) {
                tipusPreu = "pes/g";
            } else {
                vista_tpv_modificar.getjLabelTipusPreuError().setText("Tria una opcio!");
                //JOptionPane.showMessageDialog(vista_tpv_afegir, "Tria una opcio!", "ERROR", JOptionPane.WARNING_MESSAGE);
                valid = false;
            }
            //si tots els camps son correctes...
            if (valid == true) {
                System.out.println("Boto modificar premut");
                Producte p = new Producte();

                //Recollim categoria
                Categoria categoria = null;
                String nomCategoria = vista_tpv_modificar.getjComboBoxCategoria().getSelectedItem().toString().toLowerCase();
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
                boolean oferta = vista_tpv_modificar.getjCheckBoxTeOferta().isSelected();
                
                p.setNom(nom);
                p.setCategoria(categoria);
                p.setPreu(preu);
                p.setTipusPreu(tipusPreu);
                p.setStock(stock);
                p.setOferta(oferta);
                p.setSeccio(seccio);
                
                try {
                    if (ProducteDAO.getInstance().modificarProducte(p)) {
                        Controlador_tpv.getInstance().carregaSlider();
                        Controlador_tpv.getInstance().actualitzaTaulaOrdenada(ProducteDAO.getInstance().getProductes("codi", "asc"));
                        JOptionPane.showMessageDialog(vista_tpv_modificar, "Producte modificat!", "INFO_MESSAGE", JOptionPane.INFORMATION_MESSAGE); //tambe pausa l'accio fins que es tanca la finestra!!
                    } else {
                        JOptionPane.showMessageDialog(vista_tpv_modificar, "Producte no modificat!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    //System.out.println("error "+ ex);
                    JOptionPane.showMessageDialog(vista_tpv_modificar, "Ja existeix un Producte amb aquets nom!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(vista_tpv_modificar, "Error al modificar el producte \n Comprova els camps!", "ERROR", JOptionPane.WARNING_MESSAGE);
                System.out.println("Almenys un camp esta buit!");
            }
            
        }
        
    }
}
