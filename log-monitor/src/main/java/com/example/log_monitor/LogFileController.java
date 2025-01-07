package com.example.log_monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LogFileController {

    @Value("${log.scan.keywords}")
    private String[] scanKeywords;  // Error keywords from application.properties

    @GetMapping("/scan-log")
    public List<String> scanLogFile(@RequestParam String logFilePath) {
        List<String> matchingLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (containsErrorKeyword(line)) {
                    matchingLines.add(line);
                }
            }
        } catch (IOException e) {
            matchingLines.add("Error reading log file: " + e.getMessage());
        }
        return matchingLines;
    }

    private boolean containsErrorKeyword(String line) {
        return Arrays.stream(scanKeywords).anyMatch(line::contains);
    }
}
