import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.*;

class Employee {
    private int departmentId;
    private double salary;
    private int employeeId;
    private String name;

    public Employee(int departmentId, double salary, int employeeId, String name) {
        this.departmentId = departmentId;
        this.salary = salary;
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

}

public class EmployeeList {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Adding employees to the list
        employeeList.add(new Employee(1, 50000, 1001, "John Doe"));
        employeeList.add(new Employee(2, 60000, 1002, "Jane Smith"));
        employeeList.add(new Employee(1, 55000, 1003, "Mike Johnson"));
        employeeList.add(new Employee(3, 70000, 1004, "Emily Davis"));
        employeeList.add(new Employee(2, 65000, 1005, "Robert Wilson"));

//      To get the employee list based on department id
        Map<Integer,List<Employee>> emp = employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.toList()));
        emp.entrySet().forEach(entry-> {System.out.println(entry.getKey()+" " +entry.getValue());});

        System.out.println("Wap to print employee count in each department");
        Map<Integer,Long> emp1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.counting()));
        emp1.entrySet().forEach(entry-> {System.out.println(entry.getKey()+" " +entry.getValue());});
    

        Map<Integer,Long> emp3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.counting()));
        List<Integer> list = List.of(1,1,2,2,5,2,2,3,3,2,2,4) ;
        System.out.println("Wap to print unique elements count in in a list ");
        Map<Integer,Long> numberList = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        numberList.entrySet().forEach(entry-> {System.out.println(entry.getKey()+" "+ entry.getValue());});


        System.out.println("Minimum and Maximum Salary from a list of emp");
        Optional<Employee> max_salary_emp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        if(max_salary_emp.isPresent()){
            System.out.println(max_salary_emp.get().toString());
        }













        // Printing the employee details
        // for (Employee employee : employeeList) {
        //     System.out.println("Employee ID: " + employee.getEmployeeId());
        //     System.out.println("Name: " + employee.getName());
        //     System.out.println("Department ID: " + employee.getDepartmentId());
        //     System.out.println("Salary: $" + employee.getSalary());
        //     System.out.println();
        // }
    }
}
