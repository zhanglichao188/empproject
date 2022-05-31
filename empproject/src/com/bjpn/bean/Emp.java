package com.bjpn.bean;

import java.util.Objects;

public class Emp {
    private int empNo;
    private String empName;
    private String empJob;
    private String empHiredate;//建议写String
    private double empSal;
    private String empPhoto;//图片的名称
    private int deptNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(String empHiredate) {
        this.empHiredate = empHiredate;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empNo == emp.empNo && Double.compare(emp.empSal, empSal) == 0 && deptNo == emp.deptNo && Objects.equals(empName, emp.empName) && Objects.equals(empJob, emp.empJob) && Objects.equals(empHiredate, emp.empHiredate) && Objects.equals(empPhoto, emp.empPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, empName, empJob, empHiredate, empSal, empPhoto, deptNo);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", empHiredate='" + empHiredate + '\'' +
                ", empSal=" + empSal +
                ", empPhoto='" + empPhoto + '\'' +
                ", deptNo=" + deptNo +
                '}';
    }

    public Emp(int empNo, String empName, String empJob, String empHiredate, double empSal, String empPhoto, int deptNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empHiredate = empHiredate;
        this.empSal = empSal;
        this.empPhoto = empPhoto;
        this.deptNo = deptNo;
    }
    public Emp(){}
}
