package com.example.internship.service;

import com.example.internship.dto.ReportDto;

import java.time.LocalDate;

public interface ReportService {
    ReportDto getDailyReport(Long userId, LocalDate date);
}
