package aliens;


import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
 
public class pdf implements exportfile{
 
   
   
    public void export(String name,String data)
    {
        try {
 
                OutputStream file = new FileOutputStream(new File(name+".pdf"));
	        Document document = new Document();
	        PdfWriter.getInstance(document, file);
                document.open();
          
                Paragraph paragraph = new Paragraph();
                paragraph.add(data);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
                document.close();
                System.out.println("Pdf created successfully ");
   
        } 
        catch (Exception e) {
            e.printStackTrace();
        
        
        
        }
    }
}
