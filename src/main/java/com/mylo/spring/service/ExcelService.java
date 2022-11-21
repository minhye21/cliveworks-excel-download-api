package com.mylo.spring.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ExcelService {

    public static void excelDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("test");
        Row row = null;
        Cell cell = null;
        int rowNum = 0;

        String lowerRandom ="";
        for (int i = 0; i < 7; i++){
            char lowerCh = (char)((int)(Math.random()*25) + 97);
            lowerRandom += lowerCh;

        }


        //Header
        int cellNum = 0;
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue("No.");
        cell = row.createCell(1);
        cell.setCellValue("User Name");
        cell = row.createCell(2);
        cell.setCellValue("E-mail");

        //Boby
        for (int i = 1; i<=100; i++){
            cellNum = 0;
            row = sheet.createRow(rowNum++);
            cell = row.createCell(cellNum++);
            cell.setCellValue(i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("user"+i);
            cell = row.createCell(cellNum++);
            cell.setCellValue(lowerRandom+"@rmsoft.kr");
        }

        //Download
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=student.xlsx");
        try{
            wb.write(response.getOutputStream());
        } finally {
            wb.close();
        }



    }
}
