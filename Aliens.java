
package aliens;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Aliens {

         static InputStream is;
         private static byte[] inbuf = new byte[1024];
         static int lenbuf = 0, ptrbuf = 0;
         static String INPUT = "";
 
 
          public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException 
        {
 
            is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
            
            String file,name,more,data="";
            do
            {
            System.out.println("Please provide following details \n 1. Code Nmae \n 2. Blood Color \n 3. No of Antennas \n 4. No of Legs \n 5.Home Planet");
            for(int i=0;i<5;i++)
            {
                data=data+"       "+str();
            
            }
            System.out.println("do you want to add another details");
            more=str();
            data=data+"\n";
            }while(more.equalsIgnoreCase("yes")||more.equalsIgnoreCase("y"));
             
            
            System.out.println("in which file you want to export the data 1. Pdf 2. Text  \n");
            file=str().toLowerCase();
            System.out.println("please give the file name");
            name=str();
            Class c = Class.forName("aliens."+file);
            Object o=c.newInstance();
            Method  method = c.getDeclaredMethod ("export",String.class,String.class);
            method.setAccessible(true);
            method.invoke (o,name,data);

            
            
            
        }
          
           private static String str()
            {
                    StringBuffer num=new StringBuffer() ;
                    int b;
 
                    while((b = readByte()) != -1 && !((b >= '0' && b <= '9')|| b == '.'|| b == '-'|| b == '+'||(b >= 'a' && b <= 'z')||(b >= 'A' && b <= 'Z')));
                            while(true){
                            if(b >= '0' && b <= '9'|| b == '.'|| b == '-'|| b == '+'||(b >= 'a' && b <= 'z')){
                                    num=num.append((char)b);
                            }else{
                                    return num.toString();
                            }
                            b = readByte();
                    }
            }
    private static int readByte()
            {
 
                    if(ptrbuf >= lenbuf){
                            ptrbuf = 0;
                            try { lenbuf = is.read(inbuf); } catch (IOException e) { }
                            if(lenbuf <= 0)return -1;
                    }
                    return inbuf[ptrbuf++];
            }
 
}
