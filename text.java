
package aliens;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class text implements exportfile{
     
    
   public  void export(String name,String data)
    {
    
    try{
    
            FileWriter fstream = new FileWriter(name+".txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(data);
            out.close();
            System.out.println("text file created successfully..");
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
        
        
        }
}
    

