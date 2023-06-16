public class EmployeeBook {
    String name;

    public EmployeeBook(String name) {
        this.name = name;
    }

    private Employee[] employees = new Employee[10];

    public void createEmployeesBook() {
        employees[0] = new Employee("Вениаминов Валентин Эдгарович", 1, 12500);
        employees[1] = new Employee("Дуров Павел Валерьевич", 2, 13500);
        employees[2] = new Employee("Иванов Иван Иванович", 3, 15000);
        employees[3] = new Employee("Батталов Георгий Иванович", 4, 56000);
        employees[4] = new Employee("Ньюман Гарри Джонович", 5, 750000);
        employees[5] = new Employee("Борисовский Вадим Васильевич", 1, 12000);
        employees[6] = new Employee("Багров Данила Сергеевич", 2, 24000);
        employees[7] = new Employee("Кулибин Иван Петрович", 3, 25000);
        employees[8] = new Employee("Путин Владимир Владимирович", 4, 800000);
        employees[9] = new Employee("Медведев Дмитрий Анатольевич", 5, 770000);

    }

    public void otherActionsWithBook() {
        printAllEmployees(employees, 0);
        System.out.println("Затраты на заработную плату сотрудникам за месяц: " + calculateAllPayrollCosts(employees, 0) + " рублей");
        System.out.println();
        printMinimumWageEmployee(employees, 0);
        printMaximumWageEmployee(employees, 0);
        printPayrollCostsAverageValue(employees, 0);
        printEmployeesFullNames(employees, 0);
        indexationOfSalaries(employees, 10, 0);
        findInformationAndIndexationByDepartment(employees, 4, 10);
        searchEmployeesWithSalaryLessThen(employees, 100000);
        searchEmployeesWithSalaryMoreThenOrEqualTo(employees, 100000);
        deleteEmployee(employees, "Медведев Дмитрий Анатольевич", 10);
        addNewEmployee(employees, "Илон Рив Маск", 5, 1085240000);
        changeEmployeeParameters(employees, "Илон Рив Маск", 2085240000, 4);
        printAllEmployees(employees, -1);
    }

    public void printAllEmployees(Employee[] employees, int department) {
        int numberOfDepartments = 5;
        int serialNumber = 1;
        if (department == 0) {
            System.out.println("Список сотрудников:");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(i + 1 + ". " + employees[i].toString(department));
            }
            System.out.println();
        } else if (department > 0) {
            System.out.println("Список сотрудников " + department + " отдела:");
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    System.out.println(i + 1 + ". " + employees[i].toString(department));
                }
            }
        } else {
            System.out.println("Список сотрудников по отделам:");
            for (int departmentNumber = 1; departmentNumber <= numberOfDepartments; departmentNumber++) {
                System.out.println("Отдел №" + departmentNumber + ":");
                for (int i = 0; i < employees.length; i++) {

                    if (employees[i].getDepartment() == departmentNumber) {
                        System.out.println(serialNumber + ". " + employees[i].getFullName());
                        //System.out.println("i="+i + " serialNumber=" + serialNumber);
                        if (i < employees.length - 1) {
                            serialNumber++;

                        } else if (i == employees.length - 1) {
                            serialNumber = 1;
                        }

                    } else if (i == employees.length - 1) {
                        serialNumber = 1;
                    }


                }
            }

            System.out.println();
        }

    }

    public int calculateAllPayrollCosts(Employee[] employees, int department) {
        int allPayrollCosts = 0;
        if (department == 0) {
            for (int i = 0; i < employees.length; i++) {
                allPayrollCosts = allPayrollCosts + employees[i].getSalary();
            }
            return allPayrollCosts;
        } else {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    allPayrollCosts = allPayrollCosts + employees[i].getSalary();
                }
            }
            return allPayrollCosts;
        }
    }

    public void printMinimumWageEmployee(Employee[] employees, int department) {

        int minimumWage = 0;
        int minimumWageEmployeeIndex = 0;


        if (department == 0) {
            minimumWage = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalary() < minimumWage) {
                    minimumWage = employees[i].getSalary();
                    minimumWageEmployeeIndex = i;
                }
            }
        } else {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    if (minimumWage == 0) {
                        minimumWage = employees[i].getSalary();
                        minimumWageEmployeeIndex = i;
                    } else {
                        if (employees[i].getSalary() < minimumWage) {
                            minimumWage = employees[i].getSalary();
                            minimumWageEmployeeIndex = i;
                        }
                    }

                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees[minimumWageEmployeeIndex].getFullName() + ". Его зарплата составляет: " + employees[minimumWageEmployeeIndex].getSalary() + " рублей");
        if (department == 0) {
            System.out.println();
        }
    }

    public void printMaximumWageEmployee(Employee[] employees, int department) {

        int maximumWage = 0;
        int maximumWageEmployeeIndex = 0;


        if (department == 0) {
            maximumWage = employees[0].getSalary();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalary() > maximumWage) {
                    maximumWage = employees[i].getSalary();
                    maximumWageEmployeeIndex = i;
                }
            }
        } else {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    if (maximumWage == 0) {
                        maximumWage = employees[i].getSalary();
                        maximumWageEmployeeIndex = i;
                    } else {
                        if (employees[i].getSalary() > maximumWage) {
                            maximumWage = employees[i].getSalary();
                            maximumWageEmployeeIndex = i;
                        }
                    }

                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[maximumWageEmployeeIndex].getFullName() + ". Его зарплата составляет: " + employees[maximumWageEmployeeIndex].getSalary() + " рублей");
        if (department == 0) {
            System.out.println();
        }
    }

    public void printPayrollCostsAverageValue(Employee[] employees, int department) {
        if (department == 0) {
            int payrollCostsAverageValue = calculateAllPayrollCosts(employees, 0) / employees.length;
            System.out.println("Средняя заработная плата сотрудников за месяц: " + payrollCostsAverageValue + " рублей");
            System.out.println();
        } else {
            int departmentMatch = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    departmentMatch++;
                }
            }
            int payrollCostsAverageValue = calculateAllPayrollCosts(employees, department) / departmentMatch;
            System.out.println("Средняя заработная плата сотрудников " + department + " отдела за месяц: " + payrollCostsAverageValue + " рублей");
        }

    }

    public void printEmployeesFullNames(Employee[] employees, int department) {
        System.out.println("Все Ф.И.О. сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(i + 1 + ". " + employees[i].getFullName());
        }
        System.out.println();

    }

    public void indexationOfSalaries(Employee[] employees, int indexationValue, int department) {
        if (department == 0) {
            for (int i = 0; i < employees.length; i++) {
                System.out.print(i + 1 + ". " + employees[i].getSalary() + " -> ");
                employees[i].setSalaryByIndex(indexationValue);
                System.out.println(employees[i].getSalary());
            }

            System.out.println("Зарплата всех сотрудников проиндексирована на " + indexationValue + "%");
            System.out.println();
        } else {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == department) {
                    System.out.print(i + 1 + ". " + employees[i].getSalary() + " -> ");
                    employees[i].setSalaryByIndex(indexationValue);
                    System.out.println(employees[i].getSalary());
                }
            }
            System.out.println("Зарплата сотрудников " + department + " отдела проиндексирована на " + indexationValue + "%");
        }

    }

    public void findInformationAndIndexationByDepartment(Employee[] employees, int department, int indexationValue) {
        System.out.println("Информация и индексация зарплат по отделу " + department + ":");
        printMinimumWageEmployee(employees, department);
        printMaximumWageEmployee(employees, department);
        System.out.println("Затраты на заработную плату сотрудникам " + department + " отдела за месяц: " + calculateAllPayrollCosts(employees, department) + " рублей");
        printPayrollCostsAverageValue(employees, department);
        indexationOfSalaries(employees, 20, 4);
        printAllEmployees(employees, 4);
        System.out.println();
    }

    public void searchEmployeesWithSalaryLessThen(Employee[] employees, int salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            String buffer;
            if (employees[i].getSalary() < salary) {
                buffer = "id: " + employees[i].getId() + " Ф.И.О.: " + employees[i].getFullName() + " зарплата: " + employees[i].getSalary();
                System.out.println(buffer);
            }
        }
        System.out.println();
    }

    public void searchEmployeesWithSalaryMoreThenOrEqualTo(Employee[] employees, int salary) {
        System.out.println("Сотрудники с зарплатой больше " + salary + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            String buffer;
            if (employees[i].getSalary() >= salary) {
                buffer = "id: " + employees[i].getId() + " Ф.И.О.: " + employees[i].getFullName() + " зарплата: " + employees[i].getSalary();
                System.out.println(buffer);
            }
        }
        System.out.println();
    }

    public void addNewEmployee(Employee[] employees, String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return;
            }

        }
    }

    public void deleteEmployee(Employee[] employees, String fullName, int id) {

        for (int i = 0; i < employees.length; i++) {
            if (fullName != null && id != 0) {
                if (employees[i].getFullName() == fullName && employees[i].getId() == id) {
                    employees[i] = null;
                }
            } else if (fullName == null && id != 0) {
                if (employees[i].getId() == id) {
                    employees[i] = null;
                }
            } else if (fullName != null && id == 0) {
                if (employees[i].getFullName() == fullName) {
                    employees[i] = null;
                }
            }
        }
    }

    public void changeEmployeeParameters(Employee[] employees, String fullName, int salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName() == fullName) {
                if (salary != 0 && department != 0) {
                    employees[i].setSalary(salary);
                    employees[i].setDepartment(department);
                } else if (salary == 0 && department != 0) {
                    employees[i].setDepartment(department);
                } else if (salary != 0 && department == 0) {
                    employees[i].setSalary(salary);
                }

            }
        }


    }


}
