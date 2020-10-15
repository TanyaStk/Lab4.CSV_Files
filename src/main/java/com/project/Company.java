package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.format;

public class Company {
    private String companyName;
    private String abbreviation;
    private Date updateDate;
    private String address;
    private Date foundationDate;
    private int numberOfEmployees;
    private String auditor;
    private String phoneNumber;
    private String email;
    private String industry;
    private String typeOfBusiness;
    private String link;

    public Company(String inf) {
        String[] words = inf.split(";");
        try {
            companyName = words[0];
            abbreviation = words[1];
            updateDate = new SimpleDateFormat("dd.MM.yyyy").parse(words[2]);
            address = words[3];
            foundationDate = new SimpleDateFormat("dd.MM.yyyy").parse(words[4]);
            numberOfEmployees = Integer.parseInt(words[5]);
            auditor = words[6];
            phoneNumber = words[7];
            email = words[8];
            industry = words[9];
            typeOfBusiness = words[10];
            link = words[11];
        } catch (Exception ex) {
            System.out.println("Exception detected: " + ex.getLocalizedMessage());
        }
    }

    public String companyInformation() {
        String inf = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            inf = ("Company name: " + companyName + "\n" +
                    "Abbreviation: " + abbreviation + "\n" +
                    "Industry: " + industry + "\n" +
                    "Date of foundation: " + format.format(foundationDate) + "\n" +
                    "Number of employees: " + numberOfEmployees);
        } catch (Exception ex) {
            System.out.println("Exception detected: " + ex.getLocalizedMessage());
        }
        return inf;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public void setNumberOfEmployees(int amount) {
        this.numberOfEmployees = amount;
    }

    public void setAuditor(String name) {
        this.auditor = name;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getFoundationDate() {
        return this.foundationDate;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    public String getAuditor() {
        return this.auditor;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getTypeOfBusiness() {
        return this.typeOfBusiness;
    }

    public String getLink() {
        return this.link;
    }

}
