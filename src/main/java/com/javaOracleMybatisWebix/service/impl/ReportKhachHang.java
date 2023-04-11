package com.javaOracleMybatisWebix.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;


import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaOracleMybatisWebix.model.KhachHang;
import com.javaOracleMybatisWebix.service.ExcelServices;

@Service
public class ReportKhachHang {

	public XSSFWorkbook createReport(List<KhachHang> result) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheetPo = workbook.createSheet("Danh Sách Khách Hàng");
		sheetPo.setFitToPage(true);
		sheetPo.getPrintSetup().setFitWidth((short) 1);
		sheetPo.getPrintSetup().setFitHeight((short) 0);
		setPoSheet(sheetPo, result);
		return workbook;
	};

	private void setPoSheet(XSSFSheet sheet, List<KhachHang> result) {
		sheet.setColumnWidth(0, 2500);
		sheet.setColumnWidth(1, 6000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 3000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 4000);
		sheet.setColumnWidth(7, 5000);
		sheet.setColumnWidth(8, 3000);
		sheet.setColumnWidth(9, 3000);

		// XSSFRichTextString: Ä�á»‘i tÆ°á»£ng text
		XSSFRichTextString text = new XSSFRichTextString();
		// Create Front
		Font font15B = sheet.getWorkbook().createFont();
		font15B.setBold(true);
		font15B.setFontName("Times New Roman");
		font15B.setFontHeightInPoints((short) 15);

		Font font10BI = sheet.getWorkbook().createFont();
		font10BI.setFontName("Times New Roman");
		font10BI.setFontHeightInPoints((short) 10);
		font10BI.setBold(true);
		font10BI.setItalic(true);

		Font font13 = sheet.getWorkbook().createFont();
		font13.setFontName("Times New Roman");
		font13.setFontHeightInPoints((short) 13);

		Font font13B = sheet.getWorkbook().createFont();
		font13B.setBold(true);
		font13B.setFontName("Times New Roman");
		font13B.setFontHeightInPoints((short) 13);

		Font font13BI = sheet.getWorkbook().createFont();
		font13BI.setItalic(true);
		font13BI.setBold(true);
		font13BI.setFontName("Times New Roman");
		font13BI.setFontHeightInPoints((short) 13);

		Font font14 = sheet.getWorkbook().createFont();
		font14.setItalic(true);
		font14.setFontName("Times New Roman");
		font14.setFontHeightInPoints((short) 14);

		Font font14B = sheet.getWorkbook().createFont();
		font14B.setItalic(true);
		font14B.setFontName("Times New Roman");
		font14B.setFontHeightInPoints((short) 14);
		font14B.setBold(true);

		Font font14BI = sheet.getWorkbook().createFont();
		font14BI.setItalic(true);
		font14BI.setFontName("Times New Roman");
		font14BI.setFontHeightInPoints((short) 14);
		font14BI.setBold(true);
		font14BI.setItalic(true);
		// Merge Column
		// sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 9));

		text = new XSSFRichTextString("Danh Sách Khách Hàng (AnhDev)");
		text.applyFont(0, 21, font15B);
		text.applyFont(21, text.length(), font13BI);

		// XSSFCellStyle: Ä�á»‘i tÆ°á»£ng style cho Ã´
		XSSFCellStyle headerTitle = sheet.getWorkbook().createCellStyle();
		headerTitle.setAlignment(HorizontalAlignment.CENTER);
		headerTitle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerTitle.setFont(font15B);
		headerTitle.setWrapText(true);

		XSSFCellStyle styleHeaderCol = sheet.getWorkbook().createCellStyle();
		styleHeaderCol.setBorderTop(BorderStyle.THIN);
		styleHeaderCol.setBorderRight(BorderStyle.THIN);
		styleHeaderCol.setBorderLeft(BorderStyle.THIN);
		styleHeaderCol.setBorderBottom(BorderStyle.THIN);
		styleHeaderCol.setAlignment(HorizontalAlignment.CENTER);
		styleHeaderCol.setVerticalAlignment(VerticalAlignment.CENTER);
		styleHeaderCol.setFont(font14B);
		styleHeaderCol.setWrapText(true);
		
		XSSFCellStyle styleSign = sheet.getWorkbook().createCellStyle();
		styleSign.setAlignment(HorizontalAlignment.CENTER);
		styleSign.setVerticalAlignment(VerticalAlignment.CENTER);
		styleSign.setFont(font13B);
		styleSign.setWrapText(true);

		XSSFCellStyle styleData = sheet.getWorkbook().createCellStyle();
		styleData.setBorderTop(BorderStyle.THIN);
		styleData.setBorderRight(BorderStyle.THIN);
		styleData.setBorderLeft(BorderStyle.THIN);
		styleData.setBorderBottom(BorderStyle.THIN);
		styleData.setAlignment(HorizontalAlignment.CENTER);
		styleData.setVerticalAlignment(VerticalAlignment.CENTER);
		styleData.setFont(font13);
		styleData.setWrapText(true);

		XSSFCellStyle styleMaxim = sheet.getWorkbook().createCellStyle();
		styleMaxim.setAlignment(HorizontalAlignment.CENTER);
		styleMaxim.setVerticalAlignment(VerticalAlignment.CENTER);

		// XSSFRow: Ä�á»‘i tÆ°á»£ng row -> createRow thuá»™c sheet
		XSSFRow row = sheet.createRow(0);
		// XSSFCell: Ä�á»‘i tÆ°á»£ng cell -> createCell thuá»™c row
		XSSFCell cell = row.createCell(0);
// Row 0
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		text = new XSSFRichTextString("Lớp Học Lập trình - JavaWeb");
		text.applyFont(0, 19, font13);
		text.applyFont(20, text.length(), font13BI);
		cell.setCellValue(text);

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 9));
		cell = row.createCell(6);
		text = new XSSFRichTextString("Coding And Life");
		text.applyFont(font10BI);
		cell.setCellStyle(styleMaxim);
		cell.setCellValue(text);
// Row 1
		row = sheet.createRow(1);
		cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		text = new XSSFRichTextString("Chương 3: JavaBackEnd");
		text.applyFont(0, 9, font13);
		text.applyFont(10, text.length(), font13BI);
		cell.setCellValue(text);

		text = new XSSFRichTextString("#AnhDev");
		text.applyFont(font10BI);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 9));
		cell = row.createCell(6);
		cell.setCellStyle(styleMaxim);
		cell.setCellValue(text);
// Row 2
		row = sheet.createRow(2);
		cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		text = new XSSFRichTextString("Người In In: Bùi Quốc Đạt");
		text.applyFont(0, 9, font13);
		text.applyFont(10, text.length(), font13BI);
		cell.setCellValue(text);

		text = new XSSFRichTextString(".......Ngày .....Tháng....Năm.......");
		text.applyFont(font14BI);
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 6, 9));
		cell = row.createCell(6);
		cell.setCellStyle(styleMaxim);
		cell.setCellValue(text);
// Row 3
		row = sheet.createRow(3);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));
		cell = row.createCell(0);
		text = new XSSFRichTextString("Bí Danh: AnhDev");
		text.applyFont(0, 8, font13);
		text.applyFont(9, text.length(), font13BI);
		cell.setCellValue(text);
// Row 4

// Row 5
		row = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 9));
		cell = row.createCell(0);
		text = new XSSFRichTextString("Danh Sách Khách Hàng (AnhDev)");
		text.applyFont(0, 20, font15B);
		text.applyFont(21, text.length(), font13BI);
		cell.setCellValue(text);
		cell.setCellStyle(headerTitle);
		row.setHeight((short) 500);

// row 6

// Row 7 : Header Table
		row = sheet.createRow(7);
		cell = row.createCell(0);
		cell.setCellValue("STT");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(1);
		cell.setCellValue("Mã Khách Hàng");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(2);
		cell.setCellValue("Tên Khách Hàng");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(3);
		cell.setCellValue("Mã Vai Trò");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(4);
		cell.setCellValue("Vai Trò");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(5);
		cell.setCellValue("Mail");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(6);
		cell.setCellValue("SDT");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(7);
		cell.setCellValue("Ngày Sinh");
		cell.setCellStyle(styleHeaderCol);

		cell = row.createCell(8);
		cell.setCellValue("Sử Dụng");
		cell.setCellStyle(styleHeaderCol);

//		cell = row.createCell(9);
//		cell.setCellValue("2");
//		cell.setCellStyle(styleHeaderCol);

		int rowCount = sheet.getLastRowNum();
		int stt = 0;
// List
		for (KhachHang kh : result) {
			++stt;
			row = sheet.createRow(++rowCount);
			// Column STT
			cell = row.createCell(0);
			cell.setCellStyle(styleData);
			cell.setCellValue(stt);

			// Column maKh
			cell = row.createCell(1);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getMaKh());
						
			// Column Ten Khach
			cell = row.createCell(2);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getTenKh());

			// Column Ma Vai Tro
			cell = row.createCell(3);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getRoleId());
			
			// Column Vai Tro
			cell = row.createCell(4);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getRoleName());

			// Column Mail
			cell = row.createCell(5);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getMail());

			// Column SDT
			cell = row.createCell(6);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getPhone());

			// Column Ngay Sinh
			cell = row.createCell(7);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getBirthday());

			// Column Su Dung
			cell = row.createCell(8);
			cell.setCellStyle(styleData);
			cell.setCellValue(kh.getIsUse());

		}
		int lastRow = sheet.getLastRowNum() + 2;
		
		row = sheet.createRow(lastRow);
		text = new XSSFRichTextString("AnhDev");
		// Chá»¯ KÃ½ AnhDev
		sheet.addMergedRegion(new CellRangeAddress(lastRow, lastRow, 1 , 2));
		cell = row.createCell(1);
		cell.setCellValue(text);
		cell.setCellStyle(styleSign);
		// Chá»¯ KÃ½ Mentor 1
		text = new XSSFRichTextString("Mentor 1");
		cell = row.createCell(4);
		cell.setCellValue(text);
		cell.setCellStyle(styleSign);
		// Chá»¯ KÃ½ Mentor 2
		sheet.addMergedRegion(new CellRangeAddress(lastRow, lastRow, 6 , 7));
		text = new XSSFRichTextString("Mentor 2");
		cell = row.createCell(6);
		cell.setCellValue(text);
		cell.setCellStyle(styleSign);
		
		
	}

}
