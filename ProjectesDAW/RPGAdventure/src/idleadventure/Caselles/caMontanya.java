package idleadventure.Caselles;

public class caMontanya extends Casella{

    // String nom;
    // String imatge;
    // boolean walkable;


    public caMontanya(int[] position) {
        super.walkable = false;
        super.nom = "Montanya";
        super.imatge = "⛰️ ";
        super.id = 7;
        this.position = position;
    }

    public void mostraPaisatge(int distancia){
        switch (distancia) {
            case 1:
                
                break;
            case 2:
            
                break;
            case 3:
            System.out.println("""
                \033[34C\033[32m⠀⠀⡰⡇⠁⠀⠀⠀⠀⠀⠀⢀⠀⠀⡰⡇⠁⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⡰⡇⠁⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⡰⡇⠁⠀⠀
                \033[34C⠰⢾⠇⠨⡦⠀⠂⠀⠀⠀⠀⠀⠰⢾⠇⠨⡦⠀⠂⠀⠀⠀⠀⠀⠀⠰⢾⠇⠨⡦⠀⠂⠀⠀⠀⠀⠀⠀⠰⢾⠇⠨⡦⠀⠂
                \033[34C⢈⣹⠜⠻⢾⠃⠀⠀⠀⠀⡀⠀⢈⣹⠜⠻⢾⠃⠀⠀⠀⠀⠀⡀⠀⢈⣹⠜⠻⢾⠃⠀⠀⠀⠀⠀⡀⠀⢈⣹⠜⠻⢾⠃⠀
                \033[34C⣿⡵⠾⣻⣶⠿⠦⠀⠀⠀⠁⢠⣿⡵⠾⣻⣶⠿⠦⠀⠀⠀⠀⠁⢠⣿⡵⠾⣻⣶⠿⠦⠀⠀⠀⠀⠁⢠⣿⡵⠾⣻⣶⠿⠦
                \033[34C⣮⣦⡶⠻⠛⢶⣄⡀⠁⠀⢀⣠⣮⣦⡶⠻⠛⢶⣄⡀⠁⠀⠀⢀⣠⣮⣦⡶⠻⠛⢶⣄⡀⠁⠀⠀⢀⣠⣮⣦⡶⠻⠛⢶⣄
                \033[34C⠏⠁⣠⣂⣦⣈⣝⣦⣄⠀⢀⣽⠏⠁⣠⣂⣦⣈⣝⣦⣄⠀⠀⢀⣽⠏⠁⣠⣂⣦⣈⣝⣦⣄⠀⠀⢀⣽⠏⠁⣠⣂⣦⣈⣝
                \033[34C⣾⣾⠟⡙⠟⠿⣍⡉⠀⣠⣾⣵⣾⣾⠟⡙⠟⠿⣍⡉⠀⠀⣠⣾⣵⣾⣾⠟⡙⠟⠿⣍⡉⠀⠀⣠⣾⣵⣾⣾⠟⡙⠟⠿⣍
                \033[34C⣭⡶⠟⠻⣶⡰⣜⣳⣦⣠⣶⣾⣭⡶⠟⠻⣶⡰⣜⣳⣦⣄⣠⣶⣾⣭⡶⠟⠻⣶⡰⣜⣳⣦⣄⣠⣶⣾⣭⡶⠟⠻⣶⡰⣜
                \033[34C⡴⣪⠎⣄⡙⠻⠿⣯⣉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿⣯⣉⠉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿⣯⣉⠉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿
                \033[34C⣓⣭⣾⣿⢷⣬⣓⢿⠿⡶⠶⡿⣓⣭⣾⣿⢷⣬⣓⢿⠿⠉⡶⠶⡿⣓⣭⣾⣿⢷⣬⣓⢿⠿⠉⡶⠶⡿⣓⣭⣾⣿⢷⣬⣓
                \033[34C⡴⣪⠎⣄⡙⠻⠿⣯⣉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿⣯⣉⠉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿⣯⣉⠉⣴⣿⣋⡴⣪⠎⣄⡙⠻⠿\033[0m
                """);
                break;
            case 4:
            
                break;
            default:
                throw new AssertionError();
        }

    }

    
}
