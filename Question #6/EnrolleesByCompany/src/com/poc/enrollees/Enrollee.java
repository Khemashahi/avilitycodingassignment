package com.poc.enrollees;


public  class Enrollee implements Comparable<Enrollee> {
    private String userId;
    private String firstAndLastName;
    private Integer version;
    private String insuranceCompany;

    public Enrollee(String userId, String firstAndLastName, Integer version, String insuranceCompany) {
        this.userId = userId;
        this.firstAndLastName = firstAndLastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public Integer getVersion() {
        return version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    @Override
    public int compareTo(Enrollee o) {
        int result = this.getFirstAndLastName().compareTo(o.getFirstAndLastName());
        if (result == 0) {
            result = this.getVersion().compareTo(o.getVersion());
        }
        return result ;
    }

    @Override
    public String toString() {
        return userId + "," + firstAndLastName + ","  + version + "," + insuranceCompany;
    }
}
