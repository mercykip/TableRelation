package com.tables.Tables.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

@RestController
public class TempleteController {

    @Autowired
    FreeMarkerConfig freemarkerConfig;

    public boolean generatePDF(String templateName, String fullFilePath, Map model) {
        try {
            String htmlStr = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfig.getConfiguration().getTemplate(templateName), model);

            OutputStream outputStream = new FileOutputStream(fullFilePath);
            pdfGenerator(htmlStr, outputStream);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private void pdfGenerator(String htmlStr, OutputStream outputStream) throws Exception {
        System.out.println("Create builder");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        System.out.println("Create Doc");
        Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes()));
        System.out.println("Create Itext Render");
        ITextRenderer renderer = new ITextRenderer();
        System.out.println("Set doc to Itext");
        renderer.setDocument(doc, null);
        System.out.println("Create layout");
        // System.out.println("Am Waiting!!!!!");
        renderer.layout();
        System.out.println("Create PDF");
        renderer.createPDF(outputStream);
        System.out.println("Finished!!!");
        outputStream.close();
    }

    @RequestMapping(value = "/graphs", method = RequestMethod.GET)
    public boolean graphGenerator() {

      return  generatePDF("/resources/template/graphs.ftl","graphs.pdf",null);

    }
}
