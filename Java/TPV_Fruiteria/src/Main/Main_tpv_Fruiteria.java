/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

//import com.mysql.cj.exceptions.MysqlErrorNumbers;
//import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import Controlador_tpv.Controlador_tpv;
import java.sql.SQLException;

/**
 *
 * @author borras
 */
public class Main_tpv_Fruiteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Controlador_tpv.getInstance().run();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        try {
            
        } catch (Exception e) {
            
        }
    }
    
}




//preguntes
/*
true false search bbdd is 0/1 ---
totalitzacio ?? camp nou?
tablesorter tm?
unique ddbb nom
Afegir noves categories
Consultar categories disponibles

model controlador?
jpanels dinamics?  array de jpanels


//bugs

clicar el boto eliminar sense seleccionar un producte: error out of bounds
    fix -> check if isselected()
Si selecciones un producte i canvies l'ordre per les columnes,segeix marcant la casella seleccionada anteriorment, 
    fix? noope! wtf -> falta actualitzar la nova posicio de la casella seleccionada.
Si  canvies l'ordre per les columnes, ja no pots ordenar per la seleccio.
    fix? des-seleccionar.


*/


/*falta

gestio de productes:

Afegir productes amb validació de dades
---------Llistar tots els productes
Modificar productes existents
Eliminar productes existents
---------Filtrar per categoria
Filtrar per stock menor a un nombre introduït
---------Ordenar per preu

Gestió de categories:

Afegir noves categories
?---------Consultar categories disponibles
Eliminar categoria només si no hi ha productes associats

*/