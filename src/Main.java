public class Main {


    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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

        printAllEmployees(employees);
        System.out.println("Затраты на заработную плату сотрудникам за месяц: " + calculateAllPayrollCosts(employees));
        System.out.println();
        printMinimumWageEmployee(employees);
        printMaximumWageEmployee(employees);
        printPayrollCostsAverageValue(employees);
        printEmployeesFullNames(employees);


    }

    public static void printAllEmployees(Employee[] employees) {
        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(i + 1 + ". " + employees[i].toString());
        }
        System.out.println();
    }

    public static int calculateAllPayrollCosts(Employee[] employees) {
//        System.out.println("Затраты на заработную плату сотрудникам за месяц:");
        int allPayrollCosts = 0;
        for (int i = 0; i < employees.length; i++) {
            allPayrollCosts = allPayrollCosts + employees[i].getSalary();
        }
        return allPayrollCosts;
//        System.out.println(allPayrollCosts+" рублей");
//        System.out.println();
    }

    public static void printMinimumWageEmployee(Employee[] employees) {
        int minimumWage = employees[0].getSalary();
        int minimumWageEmployeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minimumWage) {

                minimumWage = employees[i].getSalary();
                minimumWageEmployeeIndex = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employees[minimumWageEmployeeIndex].getFullName() + ". Его зарплата составляет: " + employees[minimumWageEmployeeIndex].getSalary() + " рублей");
        System.out.println();
    }

    public static void printMaximumWageEmployee(Employee[] employees) {
        int maximumWage = employees[0].getSalary();
        int maximumWageEmployeeIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maximumWage) {

                maximumWage = employees[i].getSalary();
                maximumWageEmployeeIndex = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[maximumWageEmployeeIndex].getFullName() + ". Его зарплата составляет: " + employees[maximumWageEmployeeIndex].getSalary() + " рублей");
        System.out.println();
    }

    public static void printPayrollCostsAverageValue(Employee[] employees) {
        int payrollCostsAverageValue = calculateAllPayrollCosts(employees) / employees.length;
        System.out.println("Средняя заработная плата сотрудников за месяц: " + payrollCostsAverageValue + " рублей");
        System.out.println();
    }

    public static void printEmployeesFullNames(Employee[] employees) {
        System.out.println("Все Ф.И.О. сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(i + 1 + ". " + employees[i].getFullName());
        }
    }


}