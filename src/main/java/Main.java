import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

    }

    public static List<Naixements> getCustDetails(String file) throws IOException {
        List<Naixements> naixementsList =new ArrayList<>();

        // ...
        // make available CSV in URL
        URL urlCSV = new URL(file);
        // ...
        // establish connection to file in URL
        URLConnection urlConn = urlCSV.openConnection();

        // ...
        InputStreamReader inputCSV = new InputStreamReader(
                ((URLConnection) urlConn).getInputStream());

        try(BufferedReader br = new BufferedReader(inputCSV)){
            String row = br.readLine();
            while(row!=null){
                String [] attributes = row.split(",");
                Naixements naixements = getOneNaixament(attributes);
                naixementsList.add(naixements);
                row=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return naixementsList;
    }

    public static Naixements getOneNaixament(String[] attributes) {
        int any,codi_Districte,codi_Barri, nombre;
        String nom_Districte,nom_Barri,lloc_de_naixement;

        try{
            any = Integer.parseInt(attributes[0]);
        }
        catch(Exception e){any = 0;}

        try{
            codi_Districte = Integer.parseInt(attributes[1]);
        }
        catch(Exception e){codi_Districte = 0;}

        try{
            nom_Districte = attributes[2];
        }
        catch(Exception e){nom_Districte = null;}

        try{
            codi_Barri = Integer.parseInt(attributes[3]);
        }
        catch(Exception e){codi_Barri = 0;}

        try{
            nom_Barri = attributes[4];
        }
        catch(Exception e){nom_Barri = null;}

        try{
            lloc_de_naixement = attributes[5];
        }
        catch(Exception e){lloc_de_naixement = null;}

        try{
            nombre = Integer.parseInt(attributes[6]);
        }
        catch(Exception e){nombre = 0;}



        Naixements naixements = new Naixements(any,codi_Districte,nom_Districte,codi_Barri,nom_Barri,lloc_de_naixement,nombre);
        return naixements;
    }
}