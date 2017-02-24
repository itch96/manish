// read from a .xls document containg exactly 2 columns of data.
// column 1 will contain the filenames of images contained in a specific folder w/o extension.
// column 2 will contain the folder name in which to store a copy of that image file.
// read from the .xls document and do the following for every row:
// i.) read the second cell of this row and create the folder(name specified in this cell).
// ii.) read the first cell of this row and search the image file matching the name specified in this cell 
// iii.) upon finding this image file, create a copy of it in the newly created folder.
// iv.) finally create a GUI for this.

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class WriteInFile {
    public static void main(String args[]) throws Exception {
        // create a blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("MySheet");
        // create row object
        XSSFRow row;
        // This data needs to be written (Object[])
        Map<String, Object[]> info = new TreeMap<String, Object[]>();
        info.put("1", new Object[] {
            "FileName", "FolderName"});
        info.put("2", new Object[] {
            "Rahul", "Gupta"});
        info.put("3", new Object[] {
            "Surjit", "Chowdhury"});
        info.put("4", new Object[] {
            "Avinash", "Tiwari"});
        info.put("5", new Object[] {
            "Baibhav", "Jain"});
        info.put("6", new Object[] {
            "Amar", "Bal"});
        
        // iterate over data and write to sheet
        Set<String> keyid = info.keySet();
        int rowid = 0;
        for(String key : keyid) {
            row = spreadsheet.createRow(rowid ++);
            Object objArr[] = info.get(key);
            int cellid = 0;
            for(Object obj : objArr) {
                Cell cell = row.createCell(cellid ++);
                cell.setCellValue((String) obj);
            }
        }

        // write the workbook in fileSystem
        FileOutputStream fos = new FileOutputStream(new File("test.xlsx"));
        workbook.write(fos);
        fos.close();
        System.out.println("Success");
    }
}