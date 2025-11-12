package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{{"Admin", "admin123"}};
    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeData() throws IOException {
        ExcelData excel = new ExcelData();
        return excel.readExcelData();
    }

}
