import java.io.*;
import java.net.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

        


public final class Administrator extends User {

    public void manageSpace() throws IOException {


        String nameArchive = "recervas.txt";//hace que recervas no de error por el momento cuando se unan los codigos y se cree la reservacion borrenlo
       try (FileReader fr = new FileReader("reservas.txt");
             BufferedReader br = new BufferedReader(fr)) {
           
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                br.close();
            }

        } catch (IOException ex) {
            System.out.println("cannt found archive");
            ex.printStackTrace(System.out);
        }
       //
       StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta/*tenemos que poner la ruta pero como todavia en mi parte no se crea el archivo dara error por ahora*/))) {
             String linea;
             while ((linea = br.readLine()) != null) {   
             content.append(linea).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println("error reader archive: " +ex.getMessage());
        }

        String nuevoContenido = content.toString().replace("before.", "after.");// here bro
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {//aqui tambien
            bw.write(nuevoContenido);
        } catch (IOException ex) {
            System.out.println("error write archive: " +ex.getMessage());
        }

        System.out.println("midified archive.");
       
    }

    public void seeReservationMade() throws IOException {
        try (FileReader fr = new FileReader("reservas.txt");
             BufferedReader br = new BufferedReader(fr)) {
           
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                br.close();
            }

        } catch (IOException ex) {
            System.out.println("cannt found archive");
            ex.printStackTrace(System.out);
    }
    }

    public void modifyUser() {
        //sugerencia de eliminacion.
    }
    
    public void shareReservation() throws IOException {
       int puerto = 5000;  

        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("waiting connected");
            Socket socket = servidorSocket.accept();
            System.out.println("Client connected.");

            
            File archivo = new File("reservas.txt");
            FileInputStream fileInputStream = new FileInputStream(archivo);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            OutputStream outputStream = socket.getOutputStream();
            //
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Archive sent");
            bufferedInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void qualitySpace() throws IOException {
            try (FileReader fr = new FileReader("reservas.txt");
             BufferedReader br = new BufferedReader(fr)) {
           
            String linea;
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                
                br.close();
            }

        } catch (IOException ex) {
            System.out.println("cannt found archive");
            ex.printStackTrace(System.out);
    }
                
    }

    public void receiveNotification() {
        
    }
}
