

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anne
 */

import java.util.Scanner;

public class Vigenere {
    
    public String key;
    String message;
    
    public Vigenere(String key){
        this.key = key;
    }
    
    public String encode(String message){
        int i = 0;
        int j;
        String encoded = "";
        
        while(key.length() < message.length()){            
            key += key.charAt(i); //add character to the end of the key as long as key is smaller than the message
            i++;
            
        }
        
        
        for (j = 0; j < message.length(); j++){
            //converting the key to range 0-25
            int keyChar = key.charAt(j);
            //converting the message to range 0-25
            int msgChar = message.charAt(j);
            //add the index of key to add char to msgChar
            char encodedChar = (char)((msgChar + keyChar) % 26 + 65);
            
            
            encoded += encodedChar;
            
        }
        
        return encoded;
    }
    
    public String decode(String encoded){
        int j;
        String decoded = "";
        char decodedChar = 0;
        for (j = 0; j < encoded.length(); j++){
            int keyChar = key.charAt(j) - 65;
            int encodedChar = encoded.charAt(j) - 65;
            if(encodedChar < keyChar){
                decodedChar = (char)((encodedChar - keyChar + 26) + 65);
            }
            else if (encodedChar > keyChar){
                decodedChar = (char)((encodedChar - keyChar) + 65);
            }
            else if ((char)encodedChar == ' '){
                decodedChar = ' ';
            }
            decoded += decodedChar;
        }
        return decoded;
    }
    
    public static void main(String args[]){
  
        System.out.println("Enter Key: ");
        Scanner userInput = new Scanner(System.in);
        String key = userInput.nextLine();
        System.out.println("Enter Message: ");
        String message = userInput.nextLine();
        
        Vigenere obj = new Vigenere(key.toUpperCase());
        String encoded = obj.encode(message.toUpperCase());
        System.out.println("Encoded: " + encoded);     
        String decoded = obj.decode(encoded);        
        System.out.println("Decoded using Vigenere Cipher: " + decoded);
        
        
    }
}
