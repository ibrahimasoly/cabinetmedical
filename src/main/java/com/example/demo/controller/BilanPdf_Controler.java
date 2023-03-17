package com.example.demo.controller;


import com.example.demo.Pdf.BilanPdf;
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
public class BilanPdf_Controler {
    @Autowired
    BilanPdf bilanPdf;

    @GetMapping("pdfBilan/{id}")
    public ResponseEntity<byte[]> generatePDFBilan(@PathVariable int id) throws Exception {

        byte[] contents = bilanPdf.generatePdf(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "examen.pdf");
        headers.setContentLength(contents.length);

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
}
