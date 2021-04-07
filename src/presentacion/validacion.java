
package presentacion;

import java.awt.event.KeyEvent;


public class validacion {

    public static void validarNumeros (KeyEvent tecla, String texto, int cantidad) {
        
        char t=tecla.getKeyChar();
        if(Character.isDigit(t) && texto.length()<cantidad){
            
        }else{
            tecla.consume();
        }
    }
    
    public static void tamaño(KeyEvent tecla, String texto, int cantidad){
        char t= tecla.getKeyChar();
        if (texto.length()<cantidad){
            
        }else{
            tecla.consume();
        }
    }
    
    public static void validarCaracteres (KeyEvent tecla, String texto, int cantidad) {
        char t=tecla.getKeyChar();
        if(Character.isAlphabetic(t) && texto.length()<cantidad){
            
        }else{
            tecla.consume();
        }
    }
    
    public static void validarCaracteresYPuntos (KeyEvent tecla, String texto, int cantidad) {
        char t=tecla.getKeyChar();
        String letra = Character.toString(t);
        if((Character.isAlphabetic(t)|| letra.equals(".") ) && texto.length()<cantidad){
            
        }else{
            tecla.consume();
        }
    }
    
}
