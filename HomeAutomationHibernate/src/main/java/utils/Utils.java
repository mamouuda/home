/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author mouadh
 */
public class Utils {
        public static void createBat(int port,String nameFile, StringBuilder path) 
    { 
        FileOutputStream fos=null;
        DataOutputStream dos=null;
        try {
            File file = new File(nameFile+".bat");  
              if (file.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
                System.out.println("path : "+file.getAbsolutePath());
	      }
            fos = new FileOutputStream(file);            
            dos = new DataOutputStream(fos);            
            dos.writeBytes("java -jar \"C:\\Users\\mouadh\\Documents\\NetBeansProjects\\testUPnP\\dist\\testUPnP.jar\" "+port); 
            dos.close();
            fos.close();
            path.append(file.getAbsolutePath());
            
        } catch (Exception e) {
        }
    } 
}
