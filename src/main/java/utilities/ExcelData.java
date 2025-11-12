package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    private static final Logger log = LogManager.getLogger(ExcelData.class);

    public Object[][] readExcelData() throws IOException {
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\EmployeeDetails.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        int totalRows=sheet.getLastRowNum();
        int totalCells=sheet.getRow(1).getLastCellNum();
        DataFormatter formatter=new DataFormatter();

        Object[][] data=new Object[totalRows][totalCells];
        for (int r=1;r<=totalRows;r++)
        {
            XSSFRow currentRow=sheet.getRow(r);
            for (int c=0;c<totalCells;c++)
            {
                XSSFCell cell=currentRow.getCell(c);
                String cellValue= formatter.formatCellValue(cell);
                data[r-1][c]=cellValue;
                log.info(cellValue);
            }
        }
        workbook.close();
        file.close();
        return data;
    }
}
