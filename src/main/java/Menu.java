import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public Menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Consultas consultas = new Consultas();
        System.out.println("-------------------------- MENU --------------------------");

        int op;
        do{
            System.out.println("1- Mostrar tots els Naixements");
            System.out.println("2- Mostrar naixaments per Codi de Districte");
            System.out.println("3- Numero de Naixaments de un Barri en concret");
            System.out.println("4- Mostrar Ordenat Asc per Codi de Dsitricte y Codi de Barri");
            System.out.println("5- El ultim naixament (Nom mes alt)");
            System.out.println("6- Que no es repetixin els Districtes");
            System.out.println("7- Mostrar els que siguind de Districte 9 cap adalt");
            op = scanner.nextInt();

            switch (op) {
                case 1 :
                    consultas.motrarTotesCiutats();
                    break;
                case 2 :
                    consultas.mostrarNaixementsPerCodiDistricte();
                    break;
                case 3 :
                    consultas.numeroDeNaixamentsBarri();
                    break;

                case 4 :
                    consultas.ordernarAscDisBarri();
                    break;

                case 5 :
                    consultas.elMasBajo();
                    break;

                case 6 :
                    consultas.repetidos();
                    break;

                case 7 :
                    consultas.de9arriba();
                    break;


                default:
                    System.out.println("opció incorrecte");
            }
        }while( op != 0 );

    }
}
