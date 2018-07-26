package fr.Pizzeria.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ExportPizza extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizzas)  {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		document.open();
		 
		PdfPTable table = new PdfPTable(1);
		for(int i=0;i<pizzas.findAllPizzas().size();i++){
			table.addCell(pizzas.findAllPizzas().get(i).getCode()+" -> "+pizzas.findAllPizzas().get(i).getLibelle()+", "+pizzas.findAllPizzas().get(i).getPrix()+"€");
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		
	}

}
