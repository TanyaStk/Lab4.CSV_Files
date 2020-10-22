package com.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Companies.csv"))) {
            while (scanner.hasNext()) {
                Company company = new Company(scanner.nextLine());
                companies.add(company);
            }
            searchingByRequest(companies);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    static void searchingByRequest(List<Company> companies) {
        System.out.println("Select search term:\n" +
                "0 - exit;\n" +
                "1 - by abbreviation;\n" +
                "2 - by industry;\n" +
                "3 - by type of business;\n" +
                "4 - by foundation date;\n" +
                "5 - by number of employees.\n");
        try (Scanner scanner = new Scanner(System.in)) {
            FileWriter logFile =
                    new FileWriter(new File("logfile.txt"), true);
            FileWriter outputFile =
                    new FileWriter(new File("OutputFile.csv"));
            List<Company> result = new ArrayList<>();
            String category;
            RequestsManager manager = new RequestsManager(companies);
            while (!(category = scanner.next()).equals("0")) {
                String request = "";
                switch (category) {
                    case "1" -> {
                        System.out.println("Insert abbreviation:");
                        request = scanner.next();
                        result = manager.chooseCompaniesByAbbreviation(request);
                    }
                    case "2" -> {
                        System.out.println("Insert industry:");
                        request = scanner.next();
                        result = manager.chooseCompaniesByIndustry(request);
                    }
                    case "3" -> {
                        System.out.println("Insert type of business:");
                        request = scanner.next();
                        result = manager.chooseCompaniesByTypeOfBusiness(request);
                    }
                    case "4" -> {
                        System.out.println("Insert foundation date (from to, e.g. dd.MM.yyyy):");
                        Date dateFrom = new SimpleDateFormat(
                                "dd.MM.yyyy").parse(scanner.next());
                        Date dateTo = new SimpleDateFormat(
                                "dd.MM.yyyy").parse(scanner.next());
                        request += dateFrom.toString() + dateTo.toString();
                        result = manager.chooseCompaniesByFoundation(dateFrom, dateTo);
                    }
                    case "5" -> {
                        request = scanner.nextLine();
                        System.out.println("Insert number of employees(from to):");
                        int numFrom = Integer.parseInt(scanner.next());
                        int numTo = Integer.parseInt(scanner.next());
                        request += numFrom + numTo;
                        result = manager.chooseCompaniesByNumberOfEmployees(numFrom, numTo);
                    }
                }
                logWriting(logFile, request, result.size());
                fileWriting(outputFile, result);
            }
            logFile.close();
            outputFile.close();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    static void logWriting(FileWriter logFile, String request,
                           int amountFound) throws IOException {
        SimpleDateFormat formatNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date now = new Date();
        logFile.write("Date and time of running: " + formatNow.format(now) + "\n");
        logFile.write("Request: " + request + "\n");
        logFile.write("Amount of matching notes: " + amountFound + "\n");
    }

    static void fileWriting(FileWriter outputFile,
                            List<Company> inf) throws IOException {
        for (Company company : inf) {
            outputFile.append(company.toString());
            outputFile.append(",");
            outputFile.append(System.lineSeparator());
        }
    }
}
