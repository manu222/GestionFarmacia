/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para serializar y deserializar usando ficheros y objetos serializables
 * incluidos en una coleccion AbstractMap
 * @author Fernando
 */
public class FileUtil{
    static public void save(String path, AbstractMap hash){
        try(FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(hash);
        }catch(IOException e){
            System.out.println("Problema de IO al serializar");
            System.out.println(e.toString());
        }
    }

    static public AbstractMap readAbstractMap(String path){
        try(FileInputStream fis=new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(fis)){
            return (AbstractMap) oos.readObject();
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase al deserializar");
            System.out.println(e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("Problema de IO al deserializar");
            System.out.println(e.toString());
            return null;
        }
    }
    
	static public void save(String path, Map hash){
        try(FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(hash);
        }catch(IOException e){
            System.out.println("Problema de IO al serializar");
            System.out.println(e.toString());
        }
    }
    
    static public Map readMap(String path){
        try(FileInputStream fis=new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(fis)){
            return (Map) oos.readObject();
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase al deserializar");
            System.out.println(e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("Problema de IO al deserializar");
            System.out.println(e.toString());
            return null;
        }
    }
	
    static public void save(String path, List l){
        try(FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(l);
        }catch(IOException e){
            System.out.println("Problema de IO al serializar");
            System.out.println(e.toString());
        }
    }
    
    static public List readList(String path){
        try(FileInputStream fis=new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(fis)){
            return (List) oos.readObject();
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase al deserializar");
            System.out.println(e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("Problema de IO al deserializar");
            System.out.println(e.toString());
            return null;
        }
    }
    
}
