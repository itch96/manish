package manish;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.*;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    static XSSFRow row;
    static String excelLocation, photoDirectory, destinationDirectory;
    Window myWindow;
    
    App(String excel, String photo, String dest, Window obj) {
    	excelLocation = excel;
    	photoDirectory = photo;
    	destinationDirectory = dest;
    	myWindow = obj;
    }
    
    public void compute() throws Exception {
		try {
			// create a file object pointing to the excel file
	        FileInputStream fis = new FileInputStream(new File(excelLocation));

	        // create a workbook instance
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        
	        // get the spreadsheet of the workbook
	        XSSFSheet spreadsheet = workbook.getSheetAt(0);
	        
	        // get the iterator to traverse through the rows
	        Iterator<Row> rIterator = spreadsheet.iterator();
	        
	        // skipping the first row as it contains the heading(i suppose)
	        row = (XSSFRow) rIterator.next();
	        
	        // while there are rows in the sheet
	        while(rIterator.hasNext()) {
	        	// get the details of the row in the row variable
	            row = (XSSFRow) rIterator.next();
	            
	            // get the iterator for each cell in the row
	            Iterator<Cell> cIterator = row.cellIterator();
	            
	            // while there are cells in the row
	            while(cIterator.hasNext()) {
	                // for the file name
	                Cell cell = (XSSFCell) cIterator.next();
	                
	                // append the extension with the filename
	                String fileName = cell.getStringCellValue() + ".tiff";
	                
	                // store the buffer of the file in file object
	                File file = new File(photoDirectory + "/" + fileName);
	                
	                // check if the file exists 
	                if(file.exists()) {
	                    // for the folder name
	                    cell = (XSSFCell) cIterator.next();
	                    String folderName = cell.getStringCellValue();

	                    // create folder and copy the file
	                    new File(destinationDirectory + "/" + folderName).mkdir();
	                    
	                    // copy the file from ./Photos/<filename> to ./<foldername>/
	                    Path sourcefile = Paths.get(photoDirectory + "/" + fileName);
	                    Path targetDir = Paths.get(destinationDirectory + "/" + folderName);
	                    Path targetFile = targetDir.resolve(sourcefile.getFileName());
	                        
	                    Files.copy(sourcefile, targetFile);
	                    
	                    // append the task done in the log
	                    myWindow.log("\n" + photoDirectory + "/" + fileName + " is copied in\n" + destinationDirectory + "/" + folderName);
	                }
	                // if file does not exist
	                else {
	                    System.out.println(fileName + " does not exist");
	                    myWindow.log("\n" + photoDirectory + "/" + fileName + " does not exist.");
	                    // simply skip the folder
	                    cell = (XSSFCell) cIterator.next();
	                }
	            }
	            System.out.println();
	        }
	        // close the buffers
	        workbook.close();
	        fis.close();
    	}catch(Exception e) {e.printStackTrace();}
    }
}

