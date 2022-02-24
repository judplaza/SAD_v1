
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author virtual
 */
public class EditableBufferReader extends BufferedReader {

    /*public static void main(String[] args) {
       
    }*/

    public EditableBufferReader(Reader in) {
        super(in);
    }

    public void setRaw() throws IOException {
        List<String> comm = Arrays.asList("/bin/sh", "-c", "stty -echo raw </dev/tty");
        ProcessBuilder p = new ProcessBuilder(comm);
        try {
            p.start();
        } catch (IOException exception) {
            System.out.println("error setting raw mode");
        }

    }

    public void unsetRaw() {
        List<String> comm = Arrays.asList("/bin/sh", "-c", "stty echo cooked </dev/tty");
        ProcessBuilder p = new ProcessBuilder(comm);
        try {
            p.start();
        } catch (IOException exception) {
            System.out.println("error setting cooked mode");
        }
    }

    /*
    Hacer esos métodos con el program runtime
    
     */
    
    
    @Override
    public char read() throws IOException {
        
        try{
            char character = super.read();
            System.out.println(character);
            return character;
        }catch(Exception exception){
            System.out.println("Error");
        }
        
        return 0;
        

    }

    @Override
    public String readLine() {

        int c;
        int contador = 0; // se lee hasta encontrar el fin de línea 
        while ((c = System.in.read()) != '\n') {
            contador++;
            System.out.print((char) c);
        }
        System.out.println(); // Se escribe el fin de línea System.err.println( "Contados "+ contador +" bytes en total." ); } }  

    }
