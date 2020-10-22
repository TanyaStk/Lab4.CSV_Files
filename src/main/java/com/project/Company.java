package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Company {
    private final SimpleDateFormat
            format = new SimpleDateFormat("dd.MM.yyyy");

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

    public Company(String inf) throws Exception {
        String[] words = inf.split(";");
        if (words.length < 12) {
            throw new Exception();
        }
        companyName = words[0];
        abbreviation = words[1];
        updateDate = format.parse(words[2]);
        address = words[3];
        foundationDate = format.parse(words[4]);
        numberOfEmployees = Integer.parseInt(words[5]);
        auditor = words[6];
        phoneNumber = words[7];
        email = words[8];
        industry = words[9];
        typeOfBusiness = words[10];
        link = words[11];

    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", updateDate=" + format.format(updateDate) +
                ", address='" + address + '\'' +
                ", foundationDate=" + format.format(foundationDate) +
                ", numberOfEmployees=" + numberOfEmployees +
                ", auditor='" + auditor + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + industry + '\'' +
                ", typeOfBusiness='" + typeOfBusiness + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return numberOfEmployees == company.numberOfEmployees &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(abbreviation, company.abbreviation) &&
                Objects.equals(updateDate, company.updateDate) &&
                Objects.equals(address, company.address) &&
                Objects.equals(foundationDate, company.foundationDate) &&
                Objects.equals(auditor, company.auditor) &&
                Objects.equals(phoneNumber, company.phoneNumber) &&
                Objects.equals(email, company.email) &&
                Objects.equals(industry, company.industry) &&
                Objects.equals(typeOfBusiness, company.typeOfBusiness) &&
                Objects.equals(link, company.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, abbreviation, updateDate,
                address, foundationDate, numberOfEmployees,
                auditor, phoneNumber, email, industry, typeOfBusiness, link);
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
