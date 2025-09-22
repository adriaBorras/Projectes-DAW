package idleadventure.Caselles;

import idleadventure.Utils.cursorMoves;
import java.util.Arrays;

public class caCampFire extends Casella{

   
    public caCampFire(int[] position) {
        super.walkable = true;
        super.nom = "CampFire";
        super.imatge = "🏕️ ";
        super.id = 10;
        this.position = position;
    }

    public void mostraPaisatge(int distancia,int groundPosition){
        switch (distancia) {
            case 1:
            cursorMoves.moveup(groundPosition);
                System.out.println("""
                \033[34C\033[32m       -    -                   -     ⠘⢿⢦⢠⡼⣿
                \033[34C⣾⡏⢀⣠⣾⠆⠀⠀⠀⠀                         ⢶⣦⣌⣷⠏⠀⣿
                \033[34C⠉⣿⠞⣹⣏⣤⣶⡄⠀⠀ -                       ⠀⠹⣄⠙⠀⠀⠉
                \033[34C⠀⠈⠀⠙⠁⠋⠁ ⢀⡄         ⛺    ⠀-⠀⠀⠀⠀⢀⣿⠀⠀⠀⠀⠀ ⠀ ⢀⠀⠀
                \033[34C  -  ⣠⡶⣾⡿⠋   -           ⠀⠀⠀⠀⠀⠀⣼⠃⣷⠀⠀⠀⠀⡄⠀⠀⢸⣦⠀⠀
                \033[34C⢀⣠⢀⣴⠞⣩⡾⣁                 ⠀⣀⡀⠀-⠀⡿⠀⢹⠀⢀⣴⡾⢻⡆⠀⢸⡿⣆⠀
                \033[34C⣿⣿⡟⠁⢠⣟⣥⣼⡿⠃               ⠀⠘⢿⢦⣄⢸⡇⠀⢸⣶⢿⡿⠀⡌⠳⠀⣼⠇⣿⢠
                \033[34C⣿⠋  ⣿⡟⢩⡟  -              ⢶⣦⣌⣷⠙⢿⡇⠀⢸⠇⣿⣠⡾⠻⡕⣴⡏⠀⣽⠏
                \033[34C⠉   ⠸⠷⣾⠁                -⠹⣄⠙⡇⠀⠀⠀⠈⠀⠹⠏⠀⠀⠙⠟⠀⠀⠀⠀\033[0m
                """);
                break;
            case 2:
            cursorMoves.moveup(groundPosition);
                System.out.printf("""
                \033[34C\033[32m                                             %1$s
                \033[34C⠀⢀⡅⣠⠀⠀⡀⢀⠀⡀⢀⢰⠁⠀              ⠀⠀⠀⠀⠀⠀⠀⠀⢐⠁⠀⠀     %1$s
                \033[34C⡤⣧⣽⣳⣮⡄⡷⡿⡦⣙⣸⠾⣦⡝⡧            ⢄⢠⠠⡀⡀⠀⠀⠀⢰⠀⠅⡁⠀⢀⡅⣠⠀%1$s⠀
                \033[34C⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣷⡧ -   ⛺  - ⣻⣇⢱⡦⣼⢠⡦⡤⣾⣤⡗⣌⡤⣧⣽⣳⣮⡄\033[0m
                ""","");
                break;
            case 3:
            cursorMoves.moveup(groundPosition);
            System.out.printf("""
                \033[34C\033[32m                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C                                             %1$s
                \033[34C⠀⢀⡅⣠⠀⠀⡀⢀⠀⡀⢀⢰⠁⠀              ⠀⠀⠀⠀⠀⠀⠀⠀⢐⠁⠀⠀     %1$s
                \033[34C⡤⣧⣽⣳⣮⡄⡷⡿⡦⣙⣸⠾⣦⡝⡧            ⢄⢠⠠⡀⡀⠀⠀⠀⢰⠀⠅⡁⠀⢀⡅⣠⠀%1$s⠀
                \033[34C⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣷⡧  -  ⛺  - ⣻⣇⢱⡦⣼⢠⡦⡤⣾⣤⡗⣌⡤⣧⣽⣳⣮⡄\033[0m
                ""","");
                break;
            case 4:
            
                break;
            default:
                throw new AssertionError();
        }

    }


   @Override
    public void mostraInfo() {
        System.out.printf("""
                  Info Casella: 

                \033[60CNom: %s
                \033[60CImatge: %s
                \033[60Cwalkable: %s
                \033[60CPosition: %s                
                """,
                this.getNom(),
                this.getImatge(),
                this.isWalkable(),
                Arrays.toString(this.getPosition()).replace(" ", ""));
    }

    
}
