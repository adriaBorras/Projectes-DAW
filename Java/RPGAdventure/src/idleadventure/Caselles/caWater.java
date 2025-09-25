package idleadventure.Caselles;

import idleadventure.Utils.cursorMoves;

public class caWater extends Casella{

   
    public caWater(int[] position) {
        super.walkable = false;
        super.nom = "Aigua";
        super.imatge = "🟦";
        super.id = 9;
        this.position = position;
    }

    
    public void mostraPaisatge(int distancia,int groundPosition){
        switch (distancia) {
            case 1:
            
                break;
            case 2:
            cursorMoves.moveup(groundPosition);
            System.out.printf("""
                \033[34C\033[34m                                             %1$s
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⣯⣷⣷⡯⣯⣻⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[0m
                ""","");
                break;
            case 3:
            cursorMoves.moveup(groundPosition);
            System.out.printf("""
                \033[34C\033[34m                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s\033[34m
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⣯⣷⣷⡯⣯⣻⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[0m
                ""","");            
                break;
            case 4:
            
                break;
            default:
                throw new AssertionError();
        }

    }
}
