package me.eisp.first.common.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

@Controller
public class ExcelService {

    @GetMapping("/excel")
    public void excelService() {
        XSSFWorkbook wb = null;
        XSSFSheet sheet = null;
        XSSFRow row = null;
        XSSFCell cell = null;

        try {
            int rowNo = 0;
            wb = new XSSFWorkbook();
            sheet = wb.createSheet("워크 시트1");

            XSSFFont font = wb.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL);
            font.setFontHeightInPoints((short) 20);
            font.setBold(true);
            font.setColor(new XSSFColor((IndexedColorMap) Color.decode("#457ba2")));

            XSSFCellStyle cellStyle = wb.createCellStyle();
            sheet.setColumnWidth(0, (sheet.getColumnWidth(0)) + (short) 2048);

            cellStyle.setFont(font);
            //cellStyle.setAlignment();

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));
            

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }


    }

}
