import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Consultas {

    public void motrarTotesCiutats() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");

        for(Naixements naix:naixementsList){
            System.out.println(naix);
        }
    }

    public void mostrarNaixementsPerCodiDistricte() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriu un codi de Districte:");
        int codiDis = scanner.nextInt();
        for(Naixements cust:naixementsList){
            if (cust.codi_Districte == codiDis){
                System.out.println(cust);
            }
        }
    }

    public void numeroDeNaixamentsBarri() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom del Barri: ");
        String barri = scanner.nextLine();
        int countBarri = 0;
        for(Naixements naix:naixementsList){
            if (naix.getNom_Barri().equalsIgnoreCase("\""+barri+"\"")){
                countBarri++;
            }
        }
        System.out.println("La suma es: "+countBarri);
    }

    public void ordernarAscDisBarri() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");


        naixementsList.sort(Comparator.comparing(Naixements::getCodi_Barri)
                .thenComparing(Comparator.comparing(Naixements::getCodi_Districte)));

        for(Naixements naix:naixementsList){
            System.out.println(naix);
        }
    }

    public void elMasBajo() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");

        Naixements naixements =  Collections.max(naixementsList, Comparator.comparing(s -> s.getNombre()));
        System.out.println("El ultim naixament : " + naixements);

    }

    public void repetidos() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");

        List<Naixements> distinctElements = naixementsList.stream()
                .filter( distinctByKey(p -> p.getCodi_Districte()) )
                .collect( Collectors.toList() );

        for(Naixements naix:distinctElements){
            System.out.println(naix);
        }

    }


    public void de9arriba() throws IOException {
        List<Naixements> naixementsList = Main.getCustDetails("https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2019_naixements_lloc-de-naixement.csv");

        List<Naixements> hasta100 = naixementsList
                .stream()
                .filter(c -> c.codi_Districte > 9)
                .collect(Collectors.toList());

        for(Naixements naix:hasta100){
            System.out.println(naix);
        }

    }



    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
