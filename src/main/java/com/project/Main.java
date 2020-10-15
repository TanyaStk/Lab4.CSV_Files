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
    public static void main(String[] args) throws IOException {
        List<Company> companies = readFromFileIntoList();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insert dates from to (e.g. dd.MM.yyyy)");
            Date from = new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next());
            Date to = new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next());
            List<String> requested = chooseCompaniesByFoundation(from, to, companies);
            writeStatistics(from, to, requested.size());
            fileWriting(requested);
        } catch (Exception ex) {
            System.out.println("Exception detected: " + ex.getLocalizedMessage());
        }
    }

    static List<Company> readFromFileIntoList() throws IOException {
        Scanner scanner = new Scanner(new File("Companies.csv"));
        List<Company> companies = new ArrayList<>();
        while (scanner.hasNext()) {
            Company company = new Company(scanner.nextLine());
            companies.add(company);
        }
        return companies;
    }

    static List<String> chooseCompaniesByFoundation(
            Date from, Date to, List<Company> companies) {
        List<String> reqComp = new ArrayList<>();
        for (Company company : companies) {
            if (company.getFoundationDate().after(from) &&
                    company.getFoundationDate().before(to)) {
                reqComp.add(company.companyInformation());
            }
        }
        return reqComp;
    }

    static void writeStatistics(Date from, Date to, int amountFound) {
        SimpleDateFormat formatReq = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try (FileWriter writer =
                     new FileWriter(new File("logfile.txt"), true)) {
            Date now = new Date();
            writer.write("Date and time of running: " + formatNow.format(now) + "\n");
            writer.write("Inserted dates: " +
                    formatReq.format(from) + " - " + formatReq.format(to) + "\n");
            writer.write("Amount of matching notes: " + amountFound + "\n");
        } catch (IOException ex) {
            System.out.println("Exception detected: " + ex.getLocalizedMessage());
        }
    }

    static void fileWriting(List<String> inf) throws IOException {
        try (FileWriter writer =
                     new FileWriter(new File("OutputFile.csv"))) {
            for (String strings : inf) {
                writer.append(strings);
                writer.append(",");
                writer.append(System.lineSeparator());
            }
        }
    }
}
