package mazething;

public class room {

    int numRoom;
    int posicio[];
    int tamany;
    boolean isVisited = false;
    


    


    public room(int numRoom, int[] posicio, int tamany) {
        this.numRoom = numRoom;
        this.posicio = posicio;
        this.tamany = tamany;
        this.isVisited = false;
    }


    public int[] getPosicio() {
        return posicio;
    }


    public void setPosicio(int[] posicio) {
        this.posicio = posicio;
    }


    public int getTamany() {
        return tamany;
    }


    public void setTamany(int tamany) {
        this.tamany = tamany;
    }


    public int getNumRoom() {
        return numRoom;
    }


    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }


    public boolean isVisited() {
        return isVisited;
    }


    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
        if(this.isVisited()){
            
        }
    }

    


    
}
