package com.bilgeadam;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import lombok.Cleanup;

public class PDFBoxExample {

	public static void main(String[] args) {

		PDFBoxExample pdfBox = new PDFBoxExample();

		try {
			pdfBox.createPDF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createPDF() throws Exception {
		@Cleanup
		PDDocument pdf = new PDDocument(); // bir PDF belgesi yarattık
		PDPage page = new PDPage(); // bir sayfa yarattık
		pdf.addPage(page); // yarattığımız sayfayı belgeye ekledik
		
		@Cleanup
		PDPageContentStream content = new PDPageContentStream(pdf, page);
		content.beginText();
		
		content.setFont(PDType1Font.TIMES_ROMAN, 12);
		content.setLeading(14.5f);
		content.newLineAtOffset(20, 750);
		content.showText("This is an example of creating PDF with Java using PDFBox..");
		content.newLine();
		content.showText("Font is Times Roman and font size is 12.");
		content.newLine();
		content.setFont(PDType1Font.HELVETICA_BOLD, 10);
		content.showText("And now font is Helvetica Bold and font size is 10.");
		content.endText();
		content.close();
		pdf.save(new File("C:\\Users\\semih\\Desktop\\eclipse-workspace\\PDF-Excel\\PDFBoxExample.pdf"));
	}

}
