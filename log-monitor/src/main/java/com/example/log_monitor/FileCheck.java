package com.example.log_monitor;

import java.io.File;

public class FileCheck {
    public static void main(String[] args) {
        String logFilePath = "C:/Users/nkovagana/Desktop/container_worldoilcorp-G98RQ7_2024-11-09_log";
        File file = new File(logFilePath);
        if(file.exists()){
            System.out.println("File exists");
        }
        else{
            System.out.println("File not exists");
        }
    }
}
