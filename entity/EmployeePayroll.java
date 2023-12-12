package employee.javaFileIO.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeePayroll {
    /**
     * Private data members
     */
    private int id;
    private String employeeName;
    private long salary;

    /**
     * Reading input from console
     * @throws IOException
     */
    public void readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the employee ID:");
        id = Integer.parseInt(reader.readLine());

        System.out.println("Enter employee name: ");
        employeeName = reader.readLine();

        System.out.println("Enter employee salary: ");
        salary = Long.parseLong(reader.readLine());
    }
    public void writeToConsole(){
        System.out.println("Employee id : "+id);
        System.out.println("Employee name : "+employeeName);
        System.out.println("Employee salary : "+salary);
    }
}
