package com.admin.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ImportExcelDAO2 {
public static boolean importFile(InputStream in) {
	if(in!=null) {
		try {
			HSSFWorkbook wb=new HSSFWorkbook(in);
			HSSFSheet sheet=wb.getSheetAt(0);
			
			HSSFRow row; 
			HSSFCell cell;
			Iterator rows = sheet.rowIterator();

			while (rows.hasNext())
			{
				row=(HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				
				while (cells.hasNext())
				{
					cell=(HSSFCell) cells.next();
					if(cell.getColumnIndex()==0) {
						System.out.print((long)cell.getNumericCellValue());
					}else if(cell.getColumnIndex()==1){
						System.out.print(cell.getStringCellValue());
						
					}else if(cell.getColumnIndex()==2){
						
						java.util.Date dateStr = cell.getDateCellValue();
						Timestamp t=new Timestamp(dateStr.getTime());
						System.out.println(t);  
					}
					
					
				}
				System.out.println("");
			}
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	return false;
	}
}

