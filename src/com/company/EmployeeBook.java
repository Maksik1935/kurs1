package com.company;

public class EmployeeBook {
    private static Employee[] employees = new Employee[10];

    public void printEmployees() {
        for (Employee employee : employees) {
            if(employee != null) {
                System.out.println(employee.toString());
            } else {
                break;
            }
        }

    }
    public int salariesAmount() {
        int amountSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                amountSalary = amountSalary + employee.getSalary();
            } else {
                break;
            }
        }
        return amountSalary;
    }
    public int getMinSalary() {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if(employee != null) {
                if (minimumSalary > employee.getSalary()) {
                    minimumSalary = employee.getSalary();
                } else {
                    break;
                }
            }
        }
        return minimumSalary;
    }
    public int getMaxSalary() {
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                }
            } else {
                break;
            }
        }
        return maxSalary;
    }
    public int getAverageSalary() {
        int averageSalary = salariesAmount() / Employee.getId();
        return averageSalary;
    }
    public void printEmployeesNames() {
        for (Employee employee : employees) {
            if(employee != null) {
                System.out.println(employee.getNAME());
            } else {
                break;
            }
        }
    }

    public void indexSalary(int percent){
        for (Employee employee : employees) {
            if(employee != null) {
                employee.setSalary(employee.getSalary()/100*percent);
            } else {
                break;
            }
        }
    }
    public int getMinSalary(int department) {
        int minimumSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if(employee != null) {
                if(employee.getDepartment() == department) {
                    if (minimumSalary > employee.getSalary()) {
                        minimumSalary = employee.getSalary();
                    }
                } else {
                    break;
                }
            }
        }
        return minimumSalary;
    }
    public int getMaxSalary(int department) {
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if(employee.getDepartment() == department) {
                    if (maxSalary < employee.getSalary()) {
                        maxSalary = employee.getSalary();
                    }
                }

            } else {
                break;
            }
        }
        return maxSalary;
    }
    public int salariesAmount(int department) {
        int amountSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if(employee.getDepartment() == department) {
                    amountSalary = amountSalary + employee.getSalary();
                }
            } else {
                break;
            }
        }
        return amountSalary;
    }
    public int getAverageSalary(int department) {
        int averageSalary;
        int sumSalary = 0;
        int numberOfEmployees = 0;
        for(Employee employee : employees) {
            if(employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
                numberOfEmployees++;
            }
        }
        if(numberOfEmployees==0) {
            throw new NullPointerException("Нет сотрудников в этом отделе");
        } else {
            averageSalary = sumSalary / numberOfEmployees;
        }
        return averageSalary;
    }

    public void getEmployeesWithLessSalary (int salary) {
        for(Employee employee : employees) {
            if(employee.getSalary() < salary) {
                System.out.println(employee.toString());
            }
        }
    }
    public void getEmployeesWithOverSalary (int salary) {
        for(Employee employee : employees) {
            if(employee.getSalary() >= salary) {
                System.out.println(employee.toString());
            }
        }
    }

    public void addEmloyee(String name, int department, int salary) {
        Employee employee = new Employee(name, department, salary);
        for(int i = 0; i < employees.length; i++) {
            if(employees[i] == null) {
                employees[i] = employee;
            }
        }
    }
    public void removeEmployee(String name) {
        for(int i = 0; i < employees.length; i++) {
            if (employees[i].getNAME() == name) {
                employees[i] = null;
            }
        }
    }
    public void removeEmployee(int id) {
        for(int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }
    public void removeEmployee(String name, int id) {
        for(int i = 0; i < employees.length; i++) {
            if (employees[i].getNAME() == name && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }
    public void changeEmployee(String name, int salaryOrDepartment) {
        for(Employee employee : employees) {
            if(employee != null) {
                if(employee.getNAME() == name) {
                    if(salaryOrDepartment > 100) {
                        employee.setSalary(salaryOrDepartment);
                    } else if (salaryOrDepartment <= 5 && salaryOrDepartment >= 0) {
                        employee.setDepartment(salaryOrDepartment);
                    } else {
                        throw new RuntimeException("Кривые данные");
                    }
                }
            } else {
                throw new NullPointerException("Отсутсвует сотрудник с таким ФИО");
            }
        }
    }

    public void getEmployeeAboutDepartment () {
        for(int i = 1; i <=5; i++) {
            for(Employee employee : employees) {
                if (employee.getDepartment() == i) {
                    System.out.println("Отдел " + i + ". " + employee.toString());
                }
            }
        }
    }
}
