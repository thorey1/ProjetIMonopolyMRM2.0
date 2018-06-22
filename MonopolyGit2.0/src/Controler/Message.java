/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Enum.TypesMessages;
import Model.Carreau;
import java.util.ArrayList;

/**
 *
 * @author hassanyo
 */
public class Message {
    
    public Carreau carreau;
    public TypesMessages type;  // type de message
    public ArrayList<String> noms; //nom des joueurs + nombre de joueurs (.size)
    
    public Message(){}
    
}
