package com.javaOracleMybatisWebix.service.impl;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaOracleMybatisWebix.model.KhachHang;
import com.javaOracleMybatisWebix.service.ExcelServices;
import com.javaOracleMybatisWebix.service.KhachHangServices;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class Excel implements ExcelServices{
	@Autowired
	private ReportKhachHang ReportKhachHang;
	@Autowired
	private KhachHangServices KhachHangServ;
	
	@Override
	public void exportExcelListKhachHang(KhachHang khachhang,
			  							HttpServletResponse response) throws Exception{
		XSSFWorkbook workbook = ReportKhachHang.createReport(KhachHangServ.getListKhachHangByParam(khachhang));

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	};
	
}
