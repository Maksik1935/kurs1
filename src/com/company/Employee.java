package com.company;

import java.util.Objects;

public class Employee {
    private final String NAME;
    private int department;
    private int salary;
    private static int id;

    public Employee(String name, int department, int salary) {
        this.NAME = name;
        this.department = department;
        this.salary = salary;
        id++;
    }

    public String getNAME() {
        return NAME;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public static int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "NAME='" + NAME + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(NAME, employee.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, department, salary);
    }
}
