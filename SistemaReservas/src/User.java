import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * este es el codigo de user
 * @author lg809
 */


public class User {
    Scanner leer = new Scanner(System.in);
    
    
    
    private String name;
    private String id;

    
    public User(){
    }
    
    
    /**
     * esto de aqui es iniciando los atributos.
     */
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    
    /**
     * este metodo es para que se ingresen los datos de las personsa
     * no tiene mucha ciencia 
     */
    public void loadUserData(){
        
        System.out.println("ingrese su nombre por favor: ");
        this.name=leer.nextLine();
        
        System.out.println("ingrese su cedula por favor: ");
        this.id=leer.nextLine();
        
        System.out.println("los datos fueron ingresados correctamente");
        System.out.println("Nombre: "+this.name +"Cedula: "+this.id);
        }
        
    
    /**
     * este metodo permite al usuario crear una resreva(creo que aqui es donde
     * se heredan que vergazo de cosas
     */
    public void makeReservation() {
        if(this.name == null || this.id == null){
            System.out.println("no se han cargado los datos del usuario");
            return;}
        
        String detallesReservacion = "reservacion para: "+ this.name +
                "Cedula: "+this.id;
        
        try(BufferedWriter escritor = new BufferedWriter
        (new FileWriter("reservas.txt", true))){
            escritor.write(detallesReservacion);
            escritor.newLine();
            System.out.println("reserva hecha "+ detallesReservacion);
            
        }catch(IOException e){
            System.out.println("Error al realizar la reserva " + e.getMessage());
        }
        
    }
    
    
    /**
     * este metodo de aqui es para que el usuario cancele su reserva
     * le puse lector y escritor 2 para ubicarlos mas rapiddo
     */
    public void cancelReservation() {
        String detallesReservacion = this.name + " - " + this.id;
        File file = new File("reservas.txt");
        List<String> reservations = new ArrayList<>();
        
        try(BufferedReader lector2 = new BufferedReader(new FileReader(file))){
            String linea;
            boolean encontrado = false;
            while((linea = lector2.readLine()) != null){
                if(linea.equals(detallesReservacion)){
                    encontrado = true;
                }else{
                    reservations.add(linea);
                }
            }
            
            if(encontrado){
                System.out.println("reserva cancelada: " + detallesReservacion);
            }else{
                System.out.println("no se encuentra la reserva para: "
                        + detallesReservacion);
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        
        /**
         * este es para que se actualize el archivo de reservas
         */
        try(BufferedWriter escritor2 = new BufferedWriter(new FileWriter(file)))
        {
            for(String res : reservations){
                escritor2.write(res);
                escritor2.newLine();
            }
        }catch(IOException e){
            System.out.println("error en actualizar las reservas "
                    + e.getMessage());
        }
        
    }
    
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        User user = new User();
        
        while(true){
            System.out.println("--------menu de opciones----------");
            System.out.println("ingrese la opcion");
            System.out.println("1 ingresar datos de usuario");
            System.out.println("2 hacer reservas");
            System.out.println("3 cancelar reservas");
            System.out.println("4 salir");
            System.out.println("----------------------------------");
            
            int opcion = leer.nextInt();
            leer.nextLine();
            
            switch (opcion){
                case 1:
                    user.loadUserData();
                    break;
                case 2: 
                    user.makeReservation();
                    break;
                case 3:
                    user.cancelReservation();
                    break;
                case 4:
                    System.out.println("saliendo del sistema....");
                    return;
                    
                default:
                    System.out.println("opcion no valida");
                    break;
            }
            
        }
        
    }
}