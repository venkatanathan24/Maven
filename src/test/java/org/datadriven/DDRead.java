package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

public class DDRead {
	
	public static void main(String[] args) throws IOException {
		
		File f =new File("folder\\details.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fin);
		
		Sheet sh = book.getSheet("login");
		
		//int Nfrows = sh.getPhysicalNumberOfRows();
		//System.out.println("Total No of rows:  "+Nfrows);
		
		//Row r2 = sh.getRow(1);
		
		//int nfCells = r2.getPhysicalNumberOfCells();
		//System.out.println(nfCells);
		
		//Cell c1 = r2.getCell(1);
		//System.out.println(c1);
		
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			 
			Row r1 = sh.getRow(i);
			
			for (int j = 0; j < r1.getPhysicalNumberOfCells(); j++){
			Cell c = r1.getCell(j);
			
			System.out.println(c);
			
			
				
			}
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
