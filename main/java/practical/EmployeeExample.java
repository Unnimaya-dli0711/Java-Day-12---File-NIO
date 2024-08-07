package practical;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee{
    String employee_id;
    String employee_name;
    int age;
    double salary;
    String city;

    public Employee(String employee_id, String employee_name, int age, double salary, String city) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return employee_id+" "+employee_name+" "+age+" "+salary+" "+city+"\n";
    }
}
public class EmployeeExample {
    static List<Employee> employeeArrayList=new ArrayList<>();
    public static void main(String[] args) {
        //json to object
        Gson gson=new Gson();
        try(FileReader fileReader=new FileReader("src/main/java/practical/test.json")){
            Employee[] employees=gson.fromJson(fileReader, Employee[].class);
            employeeArrayList=Arrays.stream(employees).toList();
            System.out.println(employeeArrayList);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
