package com.poc;

import com.poc.enrollees.EnrolleeProcessor;

public class Main {
	public static void main(String[] args) {
       System.out.println("*********** Main method execution started ***********");
       String inputFile = args[0];
       String outputDir = args[1];
       if(inputFile != null && outputDir != null) {
    	   EnrolleeProcessor enrolleeProcessor= new EnrolleeProcessor();
           enrolleeProcessor.seperateEnrollesByCompanyName(inputFile, outputDir);
       }
       System.out.println("***********   Main method execution End   ***********");
           
	}
}
