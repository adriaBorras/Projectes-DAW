package mazething;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("holas");
        int startingPoint[] = { 1, 1 };
        int endPoint[] = { 39, 39 };

        Casella caselles[][] = new Casella[41][41];

        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {
                int posicio[] = { f, c };
                caselles[f][c] = new Casella();
                caselles[f][c].setPosition(posicio);
            }
        }
        placerooms(caselles);
        placeObjects(caselles);
        generaMapa(caselles, startingPoint, endPoint);
        dibuixaMapa(caselles);
    }

    public static void placerooms(Casella[][] caselles){

        //room rooms[] = new room[5];
        ArrayList<room> rooms = new ArrayList<>();

        room r1 = new room(1,new int[]{15,15}, 8);
        room r2 = new room(2,new int[]{5,5}, 6);
        room r3 = new room(3,new int[]{27,7}, 4);
        room r4 = new room(4,new int[]{31,23}, 4);
        room r5 = new room(5,new int[]{9,31}, 4);
        room r6 = new room(4,new int[]{29,27}, 8);

        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);

        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {

                for (room searchOfRooms : rooms) {
                    if (f >= searchOfRooms.posicio[0] && f <= searchOfRooms.posicio[0]+searchOfRooms.getTamany() && c >= searchOfRooms.posicio[1] && c <= searchOfRooms.posicio[1]+searchOfRooms.getTamany() ) {
                        caselles[f][c].setRoom(true);
                        caselles[f][c].setNumRoom(searchOfRooms.getNumRoom());
                        //System.out.println(caselles[f][c].getNumRoom());
                    }
                }
            }
        }
    }

    public static void placeObjects(Casella[][] caselles){

        caselles[33][29].setItsObject(new objecte("Trap", "🪤 "));

    }


    public static void generaMapa(Casella[][] caselles, int[] startingPoint, int[] endPoint) {

        // Scanner scanner = new Scanner(System.in);
        Casella casellaInici = caselles[startingPoint[0]][startingPoint[1]];
        //Casella casellaFinal = caselles[endPoint[0]][endPoint[1]];
        Casella casellaActual = casellaInici;
        Casella seguentCasella = casellaActual;
        String imatgeCami = "◼️ "; //◼️
        ArrayList<Casella> camiSeguit = new ArrayList<>();
        ArrayList<Casella> veins;
        Random random = new Random();
        // int posicioInici[] = { startingPoint[0], startingPoint[1] };
        // int posicioCasellaActual[] = { posicioInici[0], posicioInici[1] };
        boolean mapFinished = false;

        casellaInici.setImatge("🐁");
        casellaInici.isVisited = true;
        // dibuixaMapa(caselles);

        while (mapFinished == false) {
            boolean direccioValida = false;

            if (!buscaVeins(caselles, casellaActual).isEmpty()) {
                direccioValida = false;

                while (!direccioValida) {
                    int direccioAleatoria = random.nextInt(4);
                    switch (direccioAleatoria) {
                        case 0:
                            // Nort
                            //conecta habitacions i passadissos
                            if(casellaActual.position[0] - 2 > 0 && (caselles[casellaActual.position[0] - 2][casellaActual.position[1]]).isRoom == true && (caselles[casellaActual.position[0] - 2][casellaActual.position[1]]).isVisited == false){
                                
                                caselles[casellaActual.position[0] - 1][casellaActual.position[1]].setImatge(imatgeCami);
                                caselles[casellaActual.position[0] - 1][casellaActual.position[1]].setVisited(true);
                                //caselles[casellaActual.position[0] - 2][casellaActual.position[1]].setVisited(true);
                                 //canviem el valor de les caselles de l'habitacio a visitades:
                                for (int f = 0; f < caselles.length; f++) {
                                    for (int c = 0; c < caselles[0].length; c++) {
                                        if(caselles[f][c].getNumRoom() == (caselles[casellaActual.position[0] - 2][casellaActual.position[1]]).getNumRoom()){
                                            caselles[f][c].setVisited(true);
                                            //caselles[f][c].setImatge(String.valueOf(caselles[f][c].numRoom)+ " ");
                                        }
                                    }
                                }

                            }
                            if (casellaActual.position[0] - 2 > 0 && (!(caselles[casellaActual.position[0]- 2][casellaActual.position[1]]).isVisited && !(caselles[casellaActual.position[0]- 2][casellaActual.position[1]]).isRoom())) {
                                seguentCasella = caselles[casellaActual.position[0] - 1][casellaActual.position[1]];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    seguentCasella = caselles[casellaActual.position[0] - 1][casellaActual.position[1]];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    direccioValida = true;
                            }
                            break;
                        case 1:
                            // sud
                            if(casellaActual.position[0] + 2 < caselles.length && (caselles[casellaActual.position[0]+ 2][casellaActual.position[1]]).isRoom() && !(caselles[casellaActual.position[0]+ 2][casellaActual.position[1]]).isVisited()){
                                caselles[casellaActual.position[0] + 1][casellaActual.position[1]].setImatge(imatgeCami);
                                caselles[casellaActual.position[0] + 1][casellaActual.position[1]].setVisited(true);

                                for (int f = 0; f < caselles.length; f++) {
                                    for (int c = 0; c < caselles[0].length; c++) {
                                        if(caselles[f][c].numRoom == (caselles[casellaActual.position[0] + 2][casellaActual.position[1]]).numRoom){
                                            caselles[f][c].setVisited(true);
                                            //caselles[f][c].setImatge(String.valueOf(caselles[f][c].numRoom)+ " ");
                                        }
                                    }
                                }
                            }
                            if (casellaActual.position[0] + 2 < caselles.length && (!(caselles[casellaActual.position[0]+ 2][casellaActual.position[1]]).isVisited && !(caselles[casellaActual.position[0]+ 2][casellaActual.position[1]]).isRoom())) {
                                seguentCasella = caselles[casellaActual.position[0] + 1][casellaActual.position[1]];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    seguentCasella = caselles[casellaActual.position[0] + 1][casellaActual.position[1]];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    direccioValida = true;
                                break;
                            }
                        case 2:
                            // est
                            //conecta habitacions i passadissos
                            if(casellaActual.position[1] + 2 < caselles[0].length && (caselles[casellaActual.position[0]][casellaActual.position[1]+ 2]).isRoom() && !(caselles[casellaActual.position[0]][casellaActual.position[1]+ 2]).isVisited()){
                                caselles[casellaActual.position[0]][casellaActual.position[1] + 1].setVisited(true);
                                caselles[casellaActual.position[0]][casellaActual.position[1] + 1].setImatge(imatgeCami);

                                for (int f = 0; f < caselles.length; f++) {
                                    for (int c = 0; c < caselles[0].length; c++) {
                                        if(caselles[f][c].getNumRoom() == (caselles[casellaActual.position[0]][casellaActual.position[1]+ 2]).getNumRoom()){
                                            caselles[f][c].setVisited(true);
                                            //caselles[f][c].setImatge(String.valueOf(caselles[f][c].numRoom)+ " ");
                                        }
                                    }
                                }
                            }

                            if (casellaActual.position[1] + 2 < caselles[0].length && (!(caselles[casellaActual.position[0]][casellaActual.position[1]+ 2]).isVisited  && !(caselles[casellaActual.position[0]][casellaActual.position[1]+ 2]).isRoom())) {
                                seguentCasella = caselles[casellaActual.position[0]][casellaActual.position[1] + 1];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    seguentCasella = caselles[casellaActual.position[0]][casellaActual.position[1] + 1];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    direccioValida = true;
                            }
                            break;
                        case 3:
                            // oest
                            if(casellaActual.position[1] - 2 > 0 && (caselles[casellaActual.position[0]][casellaActual.position[1] - 2]).isRoom()  && !(caselles[casellaActual.position[0]][casellaActual.position[1] - 2]).isVisited()){
                                caselles[casellaActual.position[0]][casellaActual.position[1] - 1].setImatge(imatgeCami);
                                caselles[casellaActual.position[0]][casellaActual.position[1] - 1].setVisited(true);

                                for (int f = 0; f < caselles.length; f++) {
                                    for (int c = 0; c < caselles[0].length; c++) {
                                        if(caselles[f][c].getNumRoom() == (caselles[casellaActual.position[0]][casellaActual.position[1] - 2]).getNumRoom()){
                                            caselles[f][c].setVisited(true);
                                            //caselles[f][c].setImatge(String.valueOf(caselles[f][c].numRoom)+ " ");
                                        }
                                    }
                                }
                            }
                            if (casellaActual.position[1] - 2 > 0 && (!(caselles[casellaActual.position[0]][casellaActual.position[1] - 2]).isVisited && !(caselles[casellaActual.position[0]][casellaActual.position[1] - 2]).isRoom())) {
                                seguentCasella = caselles[casellaActual.position[0]][casellaActual.position[1] - 1];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    seguentCasella = caselles[casellaActual.position[0]][casellaActual.position[1] - 1];
                                    casellaActual = seguentCasella;
                                    casellaActual.setVisited(true);
                                    casellaActual.setImatge(imatgeCami);
                                    direccioValida = true;
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
                casellaActual.setImatge(imatgeCami);
                camiSeguit.add(casellaActual);
                // dibuixaMapa(caselles);
            } else {
                 //mapFinished = true;
                //camiSeguit.removeLast();
                if (camiSeguit.isEmpty()) {
                    mapFinished = true;
                    System.out.println("Mapa acabat");
                } else {
                    //casellaActual = camiSeguit.getLast();
                    // Scanner scanner = new Scanner(System.in);
                    // dibuixaMapa(caselles);
                    // String asd = scanner.nextLine();
                    casellaActual = camiSeguit.getFirst();
                    camiSeguit.removeFirst();
                }
            }
        }
        //casellaFinal.setImatge("🪤 ");
    }

    public static ArrayList<Casella> buscaVeins(Casella[][] caselles, Casella casellaActual) {
        ArrayList<Casella> veins = new ArrayList<>();
        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {

                if ((f != 0 && c != 0) &&
                        !caselles[f][c].isVisited && !caselles[f][c].isRoom() &&
                        ((c == casellaActual.position[1] && f == casellaActual.position[0] + 2) ||
                                (c == casellaActual.position[1] && f == casellaActual.position[0] - 2) ||
                                (c == casellaActual.position[1] + 2 && f == casellaActual.position[0]) ||
                                (c == casellaActual.position[1] - 2 && f == casellaActual.position[0]))) {
                    veins.add(caselles[f][c]);
                } else {
                }
            }
        }
        return veins;
    }

    public static void dibuixaMapa(Casella[][] caselles) {
        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {
                if(caselles[f][c].getItsObject() != null){
                    System.out.print(caselles[f][c].getItsObject().imatge);
                }else{
                    System.out.print(caselles[f][c].imatge);
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }

}