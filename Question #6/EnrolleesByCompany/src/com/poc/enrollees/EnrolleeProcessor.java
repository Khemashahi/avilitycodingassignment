package com.poc.enrollees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EnrolleeProcessor {

	public void seperateEnrollesByCompanyName(String inputFile, String outputDir) {
       
        Map<String, List<Enrollee>> enrolleesByInsurance = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
        	 String header = br.readLine();
        	String line;
            while ((line = br.readLine()) != null) {
                String[] coloumns = line.split(",");
                String userId = coloumns[0];
                String firstAndLastName = coloumns[1];
                Integer version = Integer.parseInt(coloumns[2]);
                String insuranceCompany = coloumns[3];

                Enrollee enrollee = new Enrollee(userId, firstAndLastName,  version, insuranceCompany);

                if (!enrolleesByInsurance.containsKey(insuranceCompany)) {
                    enrolleesByInsurance.put(insuranceCompany, new ArrayList<>());
                }
                enrolleesByInsurance.get(insuranceCompany).add(enrollee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, List<Enrollee>> entry : enrolleesByInsurance.entrySet()) {
            String insuranceCompany = entry.getKey();
            List<Enrollee> enrollees = entry.getValue();
            Collections.sort(enrollees);

            Map<String, Enrollee> uniqueEnrollees = new LinkedHashMap<>();
            for (Enrollee enrollee : enrollees) {
            	 uniqueEnrollees.put(enrollee.getUserId(), enrollee);
            }

            String outputFile = outputDir+File.separatorChar+ insuranceCompany + ".csv";
            System.out.println();
            System.out.println("\t*** "+outputFile+" ***");
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write("User ID,First and Last Name, Version,Insurance Company\n");
                for (Enrollee enrollee : uniqueEnrollees.values()) {
                    writer.write(enrollee.toString() + "\n");
                    System.out.println("\t"+enrollee.toString());
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   
}
