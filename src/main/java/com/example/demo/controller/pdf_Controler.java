package com.example.demo.controller;


import com.example.demo.Pdf.BilanPdf;
import com.example.demo.Pdf.pdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class pdf_Controler {
    @Autowired
    pdfService pdfService;


    @GetMapping("pdf/{id}")
    public ResponseEntity<byte[]> generatePDF(@PathVariable int id) throws Exception{
        byte[] contents = pdfService.generatePDF(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ordannance.pdf");
        headers.setContentLength(contents.length);

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
    

}
