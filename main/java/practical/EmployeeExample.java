package practical;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    static void updateField(){
        System.out.println("Enter the employee_id to update city");
        Scanner scanner=new Scanner(System.in);
        String update_id=scanner.next();
        System.out.println("Enter new city");
        String new_city=scanner.next();
        for(Employee employee:employeeArrayList){
            if(employee.getEmployee_id().equals(update_id)){
                employee.setCity(new_city);
                objectArrayToJson();
            }
        }
        System.out.println("Updated");
    }
    static void objectArrayToJson(){
        Gson gson=new Gson();
        Employee[] updated=employeeArrayList.toArray(new Employee[0]);
        try(FileWriter fileWriter=new FileWriter("src/main/java/practical/test.json");){
            gson.toJson(updated,fileWriter);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    static void jsonToObjectArray(){
        Gson gson=new Gson();
        try(FileReader fileReader=new FileReader("src/main/java/practical/test.json")){
            Employee[] employees=gson.fromJson(fileReader, Employee[].class);
            for(int i=0;i<employees.length;i++){
                String jsonemployee=gson.toJson(employees[i]);
                if(!isValidJson(jsonemployee)){
                    System.out.println("invalid format");
                    continue;
                }
            }
            employeeArrayList=Arrays.stream(employees).toList();
            System.out.println(employeeArrayList);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static boolean isValidJson(String json) {
        try {
            new Gson().fromJson(json, Object.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }
    }
    public static void main(String[] args) {
        jsonToObjectArray();
        updateField();
    }
}
