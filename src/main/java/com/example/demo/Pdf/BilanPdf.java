package com.example.demo.Pdf;

import com.example.demo.Model.Bilan;
import com.example.demo.Service.InBilan;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class BilanPdf {

    @Autowired
    InBilan bilanService;

    public byte[] generatePdf(int id) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        List<Bilan> bilan = bilanService.findByIdConsulation(id);
        Document document = new Document();
        Paragraph p = new Paragraph("BILAN");
        Paragraph p1 = new Paragraph("L'examen complimentaire a faire");
        p.setAlignment(Element.ALIGN_CENTER);
        p1.setPaddingTop(20);
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.setMargins(10, 10, 10,10);
        document.add(p);
        document.add(p1);

        for (Bilan b: bilan){
            Paragraph pa = new Paragraph(b.getId()+" "+b.getNomBilan());
            document.add(pa);
        }
        document.close();
        return outputStream.toByteArray();
    }
}
