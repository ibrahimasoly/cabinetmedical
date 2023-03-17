package com.example.demo.Pdf;

import com.example.demo.Model.Ordonnance;
import com.example.demo.Service.InOrdonnance;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class pdfService {
    @Autowired
    InOrdonnance ordonnance;

    public byte[] generatePDF(int id)throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       List<Ordonnance> ordonnance1 = ordonnance.findByIdConsulation(id);
        Document document = new Document();
        Paragraph p = new Paragraph("ORDONNANCE");
        Paragraph p1 = new Paragraph("Medicaments"+"   "+"Durée du jour"+"   "+"Quantité");
        p.setAlignment(Element.ALIGN_CENTER);
        p1.setPaddingTop(20);
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.setMargins(10, 10, 10,10);
        document.add(p);
        document.add(p1);
        for (Ordonnance o: ordonnance1){
            Paragraph p2 = new Paragraph(o.getMedicament() + "   "+ o.getDurejourprise()+"  "+o.getDose());
            document.add(p2);
        }
        document.close();
        return outputStream.toByteArray();
    }

}
