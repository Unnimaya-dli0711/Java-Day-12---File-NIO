package practical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

class Task{
    int taskId;

    public Task(int taskId, String description, String due_date, boolean completed) {
        this.taskId = taskId;
        this.description = description;
        this.due_date = due_date;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    String description;
    String due_date;
    boolean completed;

    @Override
    public String toString() {
        return "Task id: "+taskId+"\n"+"Task Description : "+description+"\n"+"Due date : "+due_date+"\n"+"Status : "+completed+"\n";
    }
}

public class TaskManagement {
    static List<Task> tasksList=new ArrayList<>();

    static void addArrayListToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter=new FileWriter("src/main/java/practical/tasks.txt")){
            String jsonArray = objectMapper.writeValueAsString(tasksList);
            System.out.println(jsonArray);
            fileWriter.write(jsonArray);
            System.out.println(tasksList);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void addTask(Scanner scanner){
        System.out.println("Enter the details of new task");
        System.out.println("Enter the id");
        int task_id=scanner.nextInt();
        System.out.println("Enter description");
        String description=scanner.next();
        System.out.println("Enter due date");
        String date=scanner.next();
        boolean status=false;
        if(!tasksList.isEmpty()){
            for(Task task:tasksList){
                if(task_id!=task.taskId){
                    tasksList.add(new Task(task_id,description,date,status));
                }
            }
        }else tasksList.add(new Task(task_id,description,date,status));


        addArrayListToJson();
    }
    static void viewAllTask(){
        System.out.println(tasksList);
    }
    static void updateTaskDetails(Scanner scanner){
        System.out.println("Enter the task id for updation");
        int update_id=scanner.nextInt();
        for(Task task:tasksList){
            if(update_id==task.taskId){
                System.out.println("Enter the choice");
                int option;
                do{
                    System.out.println("1.update description");
                    System.out.println("2.update status");
                    System.out.println("3.completed updation");
                    option=scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("Enter the description");
                            String new_description=scanner.next();
                            task.setDescription(new_description);
                            break;
                        case 2:
                            System.out.println("Enter the status");
                            boolean new_status=scanner.nextBoolean();
                            task.setCompleted(new_status);
                            break;
                        case 3:
                            System.out.println("updation completd !! exiting");
                            break;
                        default:
                            System.out.println("invalid input");
                    }
                }while(option<3);
            }
        }
        addArrayListToJson();
    }
    static void deleteTask(Scanner scanner){
        System.out.println("Enter the task id");
        int delete=scanner.nextInt();
        Task delete_task = null;
        int found=0;
        for(Task task:tasksList){
            if(delete==task.getTaskId()){
                delete_task=task;
                found=1;
                break;
            }
        }
        if(found==1)
            tasksList.remove(delete_task);
        else
            System.out.println("Task not found");
        addArrayListToJson();
    }

    static void markAsDone(Scanner scanner){
        System.out.println("Enter the task id");
        int markasdone=scanner.nextInt();
        for(Task task:tasksList){
            if(task.getTaskId()==markasdone){
                task.setCompleted(true);
            }
        }
        addArrayListToJson();
    }
    public static void main(String[] args) {
        System.out.println("Enter the choice");
        int choice;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("1.Add new task");
            System.out.println("2.view all task");
            System.out.println("3.update task details");
            System.out.println("4.delete task");
            System.out.println("5.mark as completed");
            System.out.println("6.Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewAllTask();
                    break;
                case 3:
                    updateTaskDetails(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    markAsDone(scanner);
                    break;
                case 6:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid");

            }
        }while(choice<6);
    }
}
