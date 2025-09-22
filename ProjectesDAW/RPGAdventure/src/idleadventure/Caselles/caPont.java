package idleadventure.Caselles;

import idleadventure.Utils.cursorMoves;
import java.util.Arrays;

public class caPont extends Casella{
    String imageToShow;
    boolean isBuilt = false;

    public caPont(int[] position) {
        super.walkable = true;
        super.nom = "Pont";
        super.imatge = "🌉";
        super.id = 8;
        super.position = position;
    }

    public void construirPont(){
        this.isBuilt = true;
    }

    public void mostraPaisatge(int distancia,int groundPosition){
        if(super.getMonstre() != null){
            imageToShow = super.monstre.getImatge();
            
        }else if(super.getNpc() != null){
            imageToShow = super.npc.getImatge();
            
        }else{
            imageToShow = "⣿⣿";
        }
        switch (distancia) {
            case 1:
            cursorMoves.moveup(groundPosition);
            System.out.printf("""
                \033[34C\033[34m⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⣿⣯⣷⣷\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣯⣷⣷⡯⣯⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣯⣻⣿⣟\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣟⢿⣿⣯⣷⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣯⣻⣿⣟\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿%s⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣟⢿⣿⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣿⣯⣷⣷\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣯⣷⣷⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣯⣻⣿⣟\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣟⢿⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⡯⣯⣻⣏⢿⣿⣯⣷⣷\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣯⣷⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣯⣻⣿⣟\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣟⢿⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⣯⣷⣷⣿⣏⢿⣿\033[38;5;94m⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄\033[34m⣿⣏⢿⣿⣷⣿⣟⣿⣏⢿⣿\033[0m
                """,imageToShow);
                // System.out.printf("""
                // \033[34C\033[34m⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                // \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                // \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                // \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿%s⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                // \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                // \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                // \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                // \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                // \033[34C⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[0m
                // """,imageToShow);
                break;
            case 2:
            cursorMoves.moveup(groundPosition);
            System.out.printf("""
                \033[34C\033[34m                                             %1$s
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[0m
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
                \033[34C⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷
                \033[34C⣷⣿⣟⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣟⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿
                \033[34C⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[38;5;94m⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\033[34m⣿⣏⢿⣿⣯⣷⣷⡯⣯⣻⣿⣟⣷⣿⣟⣿⣏⢿⣿\033[0m    
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
        String monsterToShow;
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
    }

    
}
