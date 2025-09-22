/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_tpv;

import Model_tpv.Categoria;
import Model_tpv.Producte;
import Persistencia.BDUtilDAO;
import Persistencia.CategoriaDAO;
import Persistencia.ProducteDAO;
import Vista_tpv.Vista_tpv;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author borras
 */
public class Controlador_tpv implements ActionListener {

    private Vista_tpv vista_tpv;
    private Vista_tpv vista_tpv_modificar;
    private DefaultTableModel tm;

    //Patró Singleton
    private static Controlador_tpv instancia = null;

    private Controlador_tpv() {

        vista_tpv = new Vista_tpv();

        //add listeners
        vista_tpv.getjButton_afegir().addActionListener(this);
        vista_tpv.getjButton_eliminar().addActionListener(this);
        vista_tpv.getjButton_modificar().addActionListener(this);
        vista_tpv.getjButtonBuscarProductes().addActionListener(this);
        //vista_tpv.getjButtonTotalitzacioMagatzem().addActionListener(this);
        vista_tpv.getjButtonInfoBuscarPer().addActionListener(this);
        vista_tpv.getjButtonAfegirCategoria().addActionListener(this);
        vista_tpv.getjButtonEliminarCategoria().addActionListener(this);

        //listener del slider
        vista_tpv.getjSliderStock().getModel().addChangeListener(e -> {
            vista_tpv.getjTextFieldSliderValue().setText(String.valueOf(vista_tpv.getjSliderStock().getValue()));
        });
        vista_tpv.getjButtonMostraStock().addActionListener(this);

        //listener jtable (com fer dinamic?)
        vista_tpv.getjTableMostraDades().getSelectionModel().addListSelectionListener(e -> {

            int filaSeleccionada = vista_tpv.getjTableMostraDades().getSelectedRow();
            if (filaSeleccionada != -1) {
                //wtf text? to string to int ?
                int seccio = Integer.parseInt(vista_tpv.getjTableMostraDades().getValueAt(filaSeleccionada, 7).toString());

                pintaBlanc();
                switch (seccio) {
                    case 1:
                        vista_tpv.getjPanelSeccio1().setBackground(Color.red);
                        break;
                    case 2:
                        vista_tpv.getjPanelSeccio2().setBackground(Color.red);
                        break;
                    case 3:
                        vista_tpv.getjPanelSeccio3().setBackground(Color.red);
                        break;
                    case 4:
                        vista_tpv.getjPanelSeccio4().setBackground(Color.red);
                        break;
                    case 5:
                        vista_tpv.getjPanelSeccio5().setBackground(Color.red);
                        break;
                    case 6:
                        vista_tpv.getjPanelSeccio6().setBackground(Color.red);
                        break;
                    case 7:
                        vista_tpv.getjPanelSeccio7().setBackground(Color.red);
                        break;
                    case 8:
                        vista_tpv.getjPanelSeccio8().setBackground(Color.red);
                        break;
                    case 9:
                        vista_tpv.getjPanelSeccio9().setBackground(Color.red);
                        break;
                    case 10:
                        vista_tpv.getjPanelSeccio10().setBackground(Color.red);
                        break;
                    case 11:
                        vista_tpv.getjPanelSeccio11().setBackground(Color.red);
                        break;
                    case 12:
                        vista_tpv.getjPanelSeccio12().setBackground(Color.red);
                        break;
                    case 13:
                        vista_tpv.getjPanelSeccio13().setBackground(Color.red);
                        break;
//                    default:
//                        throw new AssertionError();
                }
            }
        });
    }

    //Patró Singleton
    public static Controlador_tpv getInstance() {
        if (instancia == null) {
            instancia = new Controlador_tpv();
        }
        return instancia;
    }

    //executem controlador_tpv
    public void run() throws SQLException {

        try {
            BDUtilDAO.crearTaules(); //elimina i crea de nou les taules (per ara)
            BDUtilDAO.netejaTaules(); // neteja les taules buides...

            afegirDadesProva();

            fillComboboxes();
            carregarJTable();
            carregaSlider();

        } catch (Exception e) {
            e.printStackTrace();
        }

        vista_tpv.setVisible(true);
        vista_tpv.setTitle("TPV Fruiteria Tres Torres");
        vista_tpv.setLocationRelativeTo(null);
    }

    //inicialitzem comboboxes
    public void fillComboboxes() {
        //buscarPer
        vista_tpv.getjComboBoxBuscarPer().addItem("Codi");
        vista_tpv.getjComboBoxBuscarPer().addItem("Nom");
        vista_tpv.getjComboBoxBuscarPer().addItem("Stock");
        vista_tpv.getjComboBoxBuscarPer().addItem("Preu");
        vista_tpv.getjComboBoxBuscarPer().addItem("Categoria");
        vista_tpv.getjComboBoxBuscarPer().addItem("Tipus Preu");
        vista_tpv.getjComboBoxBuscarPer().addItem("Te Oferta");
        vista_tpv.getjComboBoxBuscarPer().addItem("Seccio");
        //OrdenarPer
        vista_tpv.getjComboBoxOrdenarPer().addItem("Codi");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Nom");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Stock");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Preu");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Categoria");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Tipus Preu");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Te Oferta");
        vista_tpv.getjComboBoxOrdenarPer().addItem("Seccio");
        //Eliminar Categoria
        ArrayList<Categoria> llistaCategories = new ArrayList<>();
        try {
            llistaCategories = CategoriaDAO.getInstance().getCategories();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (Categoria c : llistaCategories) {
            vista_tpv.getjComboBoxEliminarCategoria().addItem(c.getNom());
        }
    }

    public void actualitzaComboboxEliminarCategoria() {
        vista_tpv.getjComboBoxEliminarCategoria().removeAllItems();

        ArrayList<Categoria> llistaCategories = new ArrayList<>();
        try {
            llistaCategories = CategoriaDAO.getInstance().getCategories();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
        for (Categoria c : llistaCategories) {
            vista_tpv.getjComboBoxEliminarCategoria().addItem(c.getNom());
        }
    }

    //inicialitzem JTable i mostrem dades per defecte(tots els productes ordenat per codi)
    public void carregarJTable() throws SQLException {

        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Codi");
        tm.addColumn("Nom");
        tm.addColumn("Categoria");
        tm.addColumn("Preu");
        tm.addColumn("TipusPreu");
        tm.addColumn("Stock");
        tm.addColumn("Oferta");
        tm.addColumn("Seccio");
        //tm.setAutoCreateRowSorter(true);

        vista_tpv.getjTableMostraDades().setModel(tm);

        //habilitar ordenar clicant el nom de la columna
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tm);
        vista_tpv.getjTableMostraDades().setRowSorter(sorter);
        double totalEnProductes = 0;
        ArrayList<Producte> llistaProductes = ProducteDAO.getInstance().getProductes("codi", "asc");
        Object[] producte = new Object[8]; // probar fer amb objecte producte

        for (Producte p : llistaProductes) {

            producte[0] = p.getCodi();
            producte[1] = p.getNom();
            producte[2] = p.getCategoria().getNom();
            producte[3] = p.getPreu();
            producte[4] = p.getTipusPreu();
            producte[5] = p.getStock();
            //producte[6] = p.isOferta();
            producte[6] = p.isOferta() ? "Si" : "No";
            producte[7] = p.getSeccio();

            tm.addRow(producte);
            totalEnProductes = totalEnProductes + (p.getPreu() * p.getStock());
        }
        vista_tpv.getjLabelTotal().setText(String.format("Total: %.2f", totalEnProductes) + " €");
    }

    public void carregaSlider() throws SQLException {

        int max = ProducteDAO.getInstance().getMaxStock();

        int min = 0;
        int perDefecte = max / 2;
        vista_tpv.getjSliderStock().setMaximum(max);
        vista_tpv.getjSliderStock().setMinimum(min);
        vista_tpv.getjSliderStock().setValue(perDefecte);
        vista_tpv.getjLabelSliderMax().setText(String.valueOf(max));
    }

    public void afegirDadesProva() throws SQLException {
        try {
            Categoria c1 = new Categoria("Fruita");
            Categoria c2 = new Categoria("Verdura");
            Categoria c3 = new Categoria("Cereals");
            Categoria c4 = new Categoria("Fruits secs");
            Categoria c5 = new Categoria("Embotit");

            CategoriaDAO.getInstance().afegirCategoria(c1);
            CategoriaDAO.getInstance().afegirCategoria(c2);
            CategoriaDAO.getInstance().afegirCategoria(c3);
            CategoriaDAO.getInstance().afegirCategoria(c4);
            CategoriaDAO.getInstance().afegirCategoria(c5);

            Producte p1 = new Producte("Pastanaga", c2, 0.99, "Pes/Kg", 5, false, 3);
            Producte p2 = new Producte("Mandarina", c1, 1.95, "Pes/Kg", 7, false, 2);
            Producte p3 = new Producte("Llimona", c1, 2.19, "Pes/Kg", 6, false, 2);
            Producte p4 = new Producte("Cacauets", c4, 1.89, "Paquet", 23, true, 5);
            Producte p5 = new Producte("Festucs", c4, 4.59, "Paquet", 22, true, 4);
            Producte p6 = new Producte("Fuet", c5, 2.75, "Unitari", 20, false, 7);
            Producte p7 = new Producte("Patates", c2, 2.75, "Pes/Kg", 16, false, 1);

            ProducteDAO.getInstance().afegirProducte(p1);
            ProducteDAO.getInstance().afegirProducte(p2);
            ProducteDAO.getInstance().afegirProducte(p3);
            ProducteDAO.getInstance().afegirProducte(p4);
            ProducteDAO.getInstance().afegirProducte(p5);
            ProducteDAO.getInstance().afegirProducte(p6);
            ProducteDAO.getInstance().afegirProducte(p7);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;   
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista_tpv.getjButton_afegir()) {
            try {
                //vista_tpv.setVisible(false);
                Controlador_tpv_afegir.getInstance().run();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == vista_tpv.getjButton_modificar()) {

            int filaSelecionada = vista_tpv.getjTableMostraDades().getSelectedRow();
            int codi = Integer.parseInt(vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 0).toString());
            String nom = vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 1).toString();
            String categoria = vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 2).toString();
            double preu = Double.parseDouble(vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 3).toString());
            String tipusPreu = vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 4).toString();
            int stock = Integer.parseInt(vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 5).toString());
            String ofertaText = vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 6).toString().toLowerCase();
            System.out.println(ofertaText);
            Boolean oferta;
            switch (ofertaText) {
                case "si":
                    oferta = true;
                    break;
                case "no":
                    oferta = false;
                    break;
                default:
                    throw new AssertionError("No encaixa el valor amb true/false");
            }

            System.out.println(oferta);
            int seccio = Integer.parseInt(vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 7).toString());

            //Object mP = new Producte("Pastanaga", c2, 0.99, "Pes/Kg", 5, false, 3);
            try {
                //ProducteDAO.getInstance().eliminarProducte(codi);
                Controlador_tpv_modificar.getInstance().run(codi, nom, categoria, preu, tipusPreu, stock, oferta, seccio);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (ae.getSource() == vista_tpv.getjButton_eliminar()) {
            int filaSelecionada = vista_tpv.getjTableMostraDades().getSelectedRow();
            int codi = Integer.parseInt(vista_tpv.getjTableMostraDades().getValueAt(filaSelecionada, 0).toString());
            try {
                ProducteDAO.getInstance().eliminarProducte(codi);
                carregarJTable();
                carregaSlider();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pintaBlanc();

        } else if (ae.getSource() == vista_tpv.getjButtonAfegirCategoria()) {
            String categoria = vista_tpv.getjTextFieldAfegirCategoria().getText().toString();

            if (!categoria.isBlank()) {

                Categoria c = new Categoria(categoria);
                //c.setNom(categoria);
                try {
                    CategoriaDAO.getInstance().afegirCategoria(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                actualitzaComboboxEliminarCategoria();
            } else {
                JOptionPane.showMessageDialog(vista_tpv, "Camp en blanc", "ERROR", JOptionPane.WARNING_MESSAGE);
            }

        } else if (ae.getSource() == vista_tpv.getjButtonEliminarCategoria()) {

            String categoria = vista_tpv.getjComboBoxEliminarCategoria().getSelectedItem().toString();
            Categoria c = new Categoria(categoria);

            try {
                if (CategoriaDAO.getInstance().eliminarCategoria(c)) {
                    actualitzaComboboxEliminarCategoria();
                } else {
                    //JOptionPane.showMessageDialog(vista_tpv, "No pots eliminar la categoria, \n hi ha un producte asociat! \n Elimina primer els productes \n de la categoria a eliminar.", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista_tpv, "No pots eliminar la categoria, \n hi ha un producte asociat! \n Elimina primer els productes \n de la categoria a eliminar.", "ERROR", JOptionPane.WARNING_MESSAGE);

            }

        } else if (ae.getSource() == vista_tpv.getjButtonBuscarProductes()) {
            pintaBlanc(); //al buscar s'elimina la seleccio de la taula, pintem les seccions de blanc
            String dadaBuscada = "";
            String hashDadaBuscada = "";
            String ordenarPer = "";
            String buscarPer = "";

            try {
                //dada buscada:
                dadaBuscada = "%" + vista_tpv.getjTextFieldDadaBuscar().getText() + "%";
                hashDadaBuscada = generaHash(dadaBuscada);
                //System.out.println("hash: " + hashDadaBuscada);

                if (hashDadaBuscada.equals("ceec405b6c1c2e3768440c73b509ea5ab1d7403a701010ea6cc79789659285b9")) {
                    JOptionPane.showMessageDialog(vista_tpv, "\t Tachaaaaan! \n Menu secret obert!", "Menu admin", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    //opcions buscarPer:
                    switch (vista_tpv.getjComboBoxBuscarPer().getSelectedItem().toString().toLowerCase()) {
                        case "codi":
                            buscarPer = "codi";
                            break;
                        case "nom":
                            buscarPer = "nom";
                            break;
                        case "categoria":
                            buscarPer = "categoria";
                            break;
                        case "preu":
                            buscarPer = "preu";
                            break;
                        case "tipus preu":
                            buscarPer = "tipusPreu";
                            break;
                        case "stock":
                            buscarPer = "stock";
                            break;
                        case "te oferta":
                            buscarPer = "oferta";
                            break;
                        case "seccio":
                            buscarPer = "seccio";
                            break;
                        default:
                            break;
                    }
                    //opcions ordenarPer: (rule switch, el mateix que el switch, mes compacte!) (format document el fa menys compacte.....)
                    switch (vista_tpv.getjComboBoxOrdenarPer().getSelectedItem().toString().toLowerCase()) {
                        case "codi" ->
                            ordenarPer = "codi";
                        case "nom" ->
                            ordenarPer = "nom";
                        case "categoria" ->
                            ordenarPer = "categoria";
                        case "preu" ->
                            ordenarPer = "preu";
                        case "tipus preu" ->
                            ordenarPer = "tipusPreu";
                        case "stock" ->
                            ordenarPer = "stock";
                        case "te oferta" ->
                            ordenarPer = "oferta";
                        case "seccio" ->
                            ordenarPer = "seccio";
                        default -> {
                        }
                    }
                    //ProducteDAO.getInstance().getProductes(dadaBuscada, buscarPer, ordenarPer);
                    ArrayList<Producte> llistaProductesBuscats = ProducteDAO.getInstance().getProductes(dadaBuscada, buscarPer, ordenarPer);
                    //carregarJTable();
                    actualitzaTaulaOrdenada(llistaProductesBuscats);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == vista_tpv.getjButtonInfoBuscarPer()) {
            switch (vista_tpv.getjComboBoxBuscarPer().getSelectedItem().toString().toLowerCase()) {
                case "codi":
                    JOptionPane.showMessageDialog(vista_tpv, "Un numero del 1 al (num max de productes)", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "nom":
                    JOptionPane.showMessageDialog(vista_tpv, "Nom o part del nom d'un producte. \n Ex: pastana ", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "categoria":
                    //busquem les categories i fem un missatge personalitzat
                    ArrayList<Categoria> llistaCategories = new ArrayList<>();
                    String missatge = "Les categories disponibles son: ";
                    try {
                        llistaCategories = CategoriaDAO.getInstance().getCategories();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    for (Categoria c : llistaCategories) {
                        missatge = missatge + " \n -" + c.getNom();
                    }
                    JOptionPane.showMessageDialog(vista_tpv, missatge, "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "preu":
                    JOptionPane.showMessageDialog(vista_tpv, " Valor \"Double\" Ex: 20.99", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "tipus preu":
                    JOptionPane.showMessageDialog(vista_tpv, " Valors: unitari, pes/Kg, paquet", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "stock":
                    JOptionPane.showMessageDialog(vista_tpv, " Numero int. Ex: 42", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "te oferta":
                    JOptionPane.showMessageDialog(vista_tpv, "Valors: 0 o 1 ", "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "seccio":
                    JOptionPane.showMessageDialog(vista_tpv, " Numero int. Del 1 al 13.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    //joption pane.showoptiondialog
                    break;
                default:
                    break;
            }
        } else if (ae.getSource() == vista_tpv.getjButtonMostraStock()) {
            try {
                int stockNumber = Integer.parseInt(vista_tpv.getjTextFieldSliderValue().getText());
                actualitzaTaulaOrdenada(ProducteDAO.getInstance().getProductesPerStock(stockNumber));
                vista_tpv.getjSliderStock().setValue(Integer.parseInt(vista_tpv.getjTextFieldSliderValue().getText()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actualitzaTaulaOrdenada(ArrayList<Producte> llistaProductes) throws SQLException {
        try {
            DefaultTableModel taula = (DefaultTableModel) vista_tpv.getjTableMostraDades().getModel();
            taula.setRowCount(0);
            double totalEnProductes = 0;
            Object[] producte = new Object[8];
            for (Producte p : llistaProductes) {
                producte[0] = p.getCodi();
                producte[1] = p.getNom();
                producte[2] = p.getCategoria().getNom();
                producte[3] = p.getPreu();
                producte[4] = p.getTipusPreu();
                producte[5] = p.getStock();
                //producte[6] = p.isOferta();
                producte[6] = p.isOferta() ? "Si" : "No";
                producte[7] = p.getSeccio();
                taula.addRow(producte);
                //totalitzacio
                totalEnProductes = totalEnProductes + (p.getPreu() * p.getStock());

            }
            //vista_tpv.getjLabelTotal().setText("Total:" + totalEnProductes );
            
            //System.out.printf(vista_tpv.getjLabelTotal().setText(" %.2f"),totalEnProductes));
            vista_tpv.getjLabelTotal().setText(String.format("Total: %.2f", totalEnProductes) + " €");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pintaBlanc() {
        vista_tpv.getjPanelSeccio1().setBackground(Color.white);
        vista_tpv.getjPanelSeccio2().setBackground(Color.white);
        vista_tpv.getjPanelSeccio3().setBackground(Color.white);
        vista_tpv.getjPanelSeccio4().setBackground(Color.white);
        vista_tpv.getjPanelSeccio5().setBackground(Color.white);
        vista_tpv.getjPanelSeccio6().setBackground(Color.white);
        vista_tpv.getjPanelSeccio7().setBackground(Color.white);
        vista_tpv.getjPanelSeccio8().setBackground(Color.white);
        vista_tpv.getjPanelSeccio9().setBackground(Color.white);
        vista_tpv.getjPanelSeccio10().setBackground(Color.white);
        vista_tpv.getjPanelSeccio11().setBackground(Color.white);
        vista_tpv.getjPanelSeccio12().setBackground(Color.white);
        vista_tpv.getjPanelSeccio13().setBackground(Color.white);
    }

    public static String generaHash(String textToHash) {
        StringBuilder hexString = new StringBuilder();
        try {
            //creem MessageDigest
            MessageDigest tipusHashDigest = MessageDigest.getInstance("SHA-256");
            //fem hash dels bits del string
            byte[] hashBytes = tipusHashDigest.digest(textToHash.getBytes());
            //generem String dels bytes del hash
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return hexString.toString();
    }

}
