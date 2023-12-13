package employee.javaFileIO.service;

import employee.javaFileIO.entity.EmployeePayroll;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeService {
    public void run() throws IOException {
        System.out.println("Employee Payroll Service: ");
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.readFromConsole();
        System.out.println("Employee Details: ");
        employeePayroll.writeToConsole();
        writeInFile(employeePayroll);
    }

    /**
     * Write Employee details in file
     * @param employeePayroll
     * @throws IOException
     */
    private void writeInFile(EmployeePayroll employeePayroll) throws IOException {
        FileWriter writer = new FileWriter("G:\\GE-work\\employeePayroll\\src\\main\\java\\employee\\javaFileIO\\employee.txt");
        writer.write("ID : "+employeePayroll.id+"\n");
        writer.write("Name : "+employeePayroll.employeeName+"\n");
        writer.write("Salary : "+employeePayroll.salary+"\n");
        writer.close();
    }
}
