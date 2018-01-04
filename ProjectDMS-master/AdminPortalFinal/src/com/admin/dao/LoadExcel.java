package com.admin.dao;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.admin.bean.Device;
import com.admin.bean.DeviceStatus;

public class LoadExcel {
	private static Logger log=Logger.getLogger(LoadExcel.class);
	public static List<Device> importFile(InputStream in) {
		
		boolean flag=true;
		List<Device> devicelist=new ArrayList<Device>();
			try {
				HSSFWorkbook wb=new HSSFWorkbook(in);
				HSSFSheet sheet=wb.getSheetAt(0);
				
				HSSFRow row; 
				HSSFCell cell;
				Iterator rows = sheet.rowIterator();

				while (rows.hasNext())
				{	flag=true;
					row=(HSSFRow) rows.next();
					Iterator cells = row.cellIterator();
                    Device d;
                    d=new Device();
					while (cells.hasNext())
					{
						
						cell=(HSSFCell) cells.next();
						if(cell.getColumnIndex()==0) {
							d.setDevice_id((long)cell.getNumericCellValue());
						}else if(cell.getColumnIndex()==1){
							d.setStatus(DeviceStatus.NEW);
							System.out.print(cell.getStringCellValue());
							
							
						}else if(cell.getColumnIndex()==2){
							if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
							String string=cell.getStringCellValue();
							DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
							Date date = format.parse(string);
							//java.util.Date dateStr =new Date(); 
							Timestamp t=new Timestamp(date.getTime());
							d.setValid_till(t);  
							}else {
								log.info("valid till date in not good format");
								flag=false;
							}
						
						}
					}
					if(flag)
						devicelist.add(d);
				}
			
			
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
	
		return devicelist;
		}
}
