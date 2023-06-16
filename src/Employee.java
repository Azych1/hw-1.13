public class Employee {
    String fullName;
    int department;
    int salary;
    int id;

    static int counter = 1;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter;
        this.counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSalaryByIndex(int indexationValue) {
        this.salary = this.salary*(indexationValue+100)/100;
    }

    public String toString(int department) {
       String buffer = "Ф.И.О.: "+fullName.toString()+" Отдел: " + department +" Заработная плата: "+salary+" рублей ";
       if(department==0){
           buffer = buffer+"id: "+id;
       }
       return buffer;
    }

}
