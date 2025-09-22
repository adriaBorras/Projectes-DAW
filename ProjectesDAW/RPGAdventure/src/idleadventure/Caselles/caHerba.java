package idleadventure.Caselles;

import idleadventure.Utils.cursorMoves;
import java.util.Arrays;

public class caHerba extends Casella{
    String imageToShow;
   
    public caHerba(int[] position) {
        super.walkable = true;
        super.nom = "Herba";
        super.imatge = "🟩";
        super.id = 6;
        super.position = position;
    }

    public void mostraPaisatge(int distancia,int groundPosition){
        if(super.getMonstre() != null){
            imageToShow = super.monstre.getImatge();
            
        }else if(super.getNpc() != null){
            imageToShow = super.npc.getImatge();
            
        }else{
            imageToShow = "  ";
        }
        switch (distancia) {
            case 1:
            cursorMoves.moveup(groundPosition);
                System.out.printf("""
                \033[34C\033[32m       -    -                   -     ⠘⢿⢦⢠⡼⣿⢦
                \033[34C⣾⡏⢀⣠⣾⠆⠀⠀⠀⠀                         ⢶⣦⣌⣷⠏⠀⣿  ⡿
                \033[34C⠉⣿⠞⣹⣏⣤⣶⡄⠀⠀ -                       ⠀⠹⣄⠙⠀⠀⠉  ⠈
                \033[34C⠀⠈⠀⠙⠁⠋⠁ ⢀⡄         %s    ⠀-⠀⠀⠀⠀⢀⣿⠀⠀⠀⠀⠀ ⠀ ⢀⠀ -  
                \033[34C  -  ⣠⡶⣾⡿⠋   -           ⠀⠀⠀⠀⠀⠀⣼⠃⣷⠀⠀⠀⠀⡄⠀⠀⢸⣦⠀⠀  
                \033[34C⢀⣠⢀⣴⠞⣩⡾⣁                 ⠀⣀⡀⠀-⠀⡿⠀⢹⠀⢀⣴⡾⢻⡆⠀⢸⡿⣆⠀
                \033[34C⣿⣿⡟⠁⢠⣟⣥⣼⡿⠃               ⠀⠘⢿⢦⣄⢸⡇⠀⢸⣶⢿⡿⠀⡌⠳⠀⣼⠇⣿⢠
                \033[34C⣿⠋  ⣿⡟⢩⡟  -              ⢶⣦⣌⣷⠙⢿⡇⠀⢸⠇⣿⣠⡾⠻⡕⣴⡏⠀⣽⠏
                \033[34C⠉   ⠸⠷⣾⠁                -⠹⣄⠙⡇⠀⠀⠀⠈⠀⠹⠏⠀⠀⠙⠟⠀⠀⠀⠙⡇\033[0m
                """,imageToShow);
                break;
            case 2:
            cursorMoves.moveup(groundPosition);
                System.out.printf("""
                \033[34C\033[32m                                             %1$s
                \033[34C⠀⢀⡅⣠⠀⠀⡀⢀⠀⡀⢀⢰⠁⠀              ⠀⠀⠀⠀⠀⠀⠀⠀⢐⠁⠀⠀     %1$s
                \033[34C⡤⣧⣽⣳⣮⡄⡷⡿⡦⣙⣸⠾⣦⡝⡧            ⢄⢠⠠⡀⡀⠀⠀⠀⢰⠀⠅⡁⠀⢀⡅⣠⠀%1$s⠀
                \033[34C⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣷⡧ -   %2$s  - ⣻⣇⢱⡦⣼⢠⡦⡤⣾⣤⡗⣌⡤⣧⣽⣳⣮⡄\033[0m
                ""","",imageToShow);
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
                \033[34C⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣷⡧  -  %2$s  - ⣻⣇⢱⡦⣼⢠⡦⡤⣾⣤⡗⣌⡤⣧⣽⣳⣮⡄\033[0m
                ""","",imageToShow);
                break;
            case 4:
            
                break;
            default:
                throw new AssertionError();
        }

    }


    @Override
    public void mostraInfo() {
        String monsterToShow;
        String npcToShow;
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
        if (super.monstre != null) {
            monsterToShow = super.monstre.getImatge();
            System.out.printf("""
                \033[60CMonster: %s 
                """,
                monsterToShow);
        }
        if(super.monstre != null && super.monstre.isInteracted()){
            System.out.printf("""
                \033[60C ⤷ HP: %d STR: %d
                """,
                super.monstre.getVida(),super.monstre.getStr());
        }
        if(super.npc != null) {
            npcToShow = super.npc.getImatge();
            System.out.printf("""
                \033[60CNPC: %s 
                """,
                npcToShow);
        }
        if(super.npc != null && super.npc.isInteracted()){
            System.out.printf("""
                \033[60C ⤷ HP: %d STR: %d
                """,
                super.npc.getVida(),super.npc.getStr());
        }
        
    }
    
}
