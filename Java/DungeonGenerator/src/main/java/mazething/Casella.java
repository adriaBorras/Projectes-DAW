package mazething;

public class Casella {

    String imatge = "🟫";
    boolean isVisited = false;
    int position[] = {0,0};
    boolean isRoom = false;
    int numRoom = 0;
    boolean hasTrap = false;
    objecte itsObject = null;


    public Casella() {
        this.imatge = imatge;
        this.isVisited = isVisited;
        this.position = position;
        this.numRoom = numRoom;
    }

    

    public boolean isHasTrap() {
        return hasTrap;
    }



    public void setHasTrap(boolean hasTrap) {
        this.hasTrap = hasTrap;
    }



    public objecte getItsObject() {
        return itsObject;
    }



    public void setItsObject(objecte itsObject) {
        this.itsObject = itsObject;
    }



    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }



    public boolean isRoom() {
        return isRoom;
    }



    public void setRoom(boolean isRoom) {
        this.isRoom = isRoom;
        if(isRoom()){
            this.imatge = "◼️ "; //◼️
            //this.isVisited = true;
        }else{
            this.imatge = "🟫";
        }
        
    }



    public int getNumRoom() {
        return numRoom;
    }



    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
    

    
}
