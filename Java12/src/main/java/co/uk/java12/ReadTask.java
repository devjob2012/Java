package co.uk.java12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadTask {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ace", 22, 2000.0, 5924001);
        Employee emp2 = new Employee("John", 25, 3000.0, 5923401);
        Employee emp3 = new Employee("Keith", 35, 6000.0, 5544401);
        List<Employee> lsEmployee = new ArrayList<>();
        lsEmployee.add(emp3);
        lsEmployee.add(emp2);
        lsEmployee.add(emp1);
        Comparator.comparing(Employee::getAge);

        lsEmployee.sort(Comparator.comparing(Employee::getAge));
        System.out.println(lsEmployee);

        lsEmployee.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.println(lsEmployee);
    }
}
