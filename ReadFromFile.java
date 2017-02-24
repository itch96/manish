import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromFile {
    static XSSFRow row;
    public static void main(String args[]) throws Exception {
        FileInputStream fis = new FileInputStream(new File("test.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator<Row> rIterator = spreadsheet.iterator();
        while(rIterator.hasNext()) {
            row = (XSSFRow) rIterator.next();
            Iterator<Cell> cIterator = row.cellIterator();
            while(cIterator.hasNext()) {
                Cell cell = (XSSFCell) cIterator.next();   
                System.out.print(cell.getStringCellValue() + "\t\t");
            }
            System.out.println();
        }
        fis.close();
    }
}