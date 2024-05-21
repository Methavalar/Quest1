package com.example.Quest1.Quest1.controllers;

import com.example.Quest1.Quest1.repository.ReportRepository;
import com.example.Quest1.Quest1.dto.ReportResponse;
import com.example.Quest1.Quest1.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reports")
    public List<ReportResponse> findAllReports() {
        return reportRepository.findAll();
    }

    @GetMapping("/reports/{id}")
    public ReportResponse findReportById(@PathVariable int id) {
        return reportRepository.findById(id);
    }

    @DeleteMapping("/reports/{id}")
    public String deleteReportById(@PathVariable int id) {
        return reportRepository.deleteById(id)+" Report delete from the database";
    }

    @PostMapping("/reports")
    public String saveReport(@RequestBody Report e) {
        return reportRepository.save(e)+" Report saved successfully";
    }

    @PutMapping("/reports/{id}")
    public String updateReport(@RequestBody Report e, @PathVariable int id) {
        return reportRepository.update(e, id)+" Report updated successfully";
    }
}
