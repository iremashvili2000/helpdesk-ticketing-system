package com.example.helpdeskticketingsystem.service;

import com.example.helpdeskticketingsystem.entity.model.TicketResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TicketExcelReportService implements ReportGenerator<TicketResponse>{

    @Override
    public ByteArrayInputStream generate(List<TicketResponse> tickets) throws IOException {
        String[] columns = {"ID", "სათაური", "სტატუსი", "პრიორიტეტი", "შემქმნელი", "თარიღი"};

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Filtered Tickets");

            // 1. შევქმნათ ჰედერი (სათაურების ხაზი)
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // 2. შევავსოთ მონაცემებით
            int rowIdx = 1;
            for (TicketResponse ticket : tickets) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(ticket.getId());
                row.createCell(1).setCellValue(ticket.getTitle());
                row.createCell(2).setCellValue(ticket.getStatus().toString());
                row.createCell(3).setCellValue(ticket.getPriority().toString());
                row.createCell(4).setCellValue(ticket.getCreatorName());
                row.createCell(5).setCellValue(ticket.getCreatedAt().toString());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
