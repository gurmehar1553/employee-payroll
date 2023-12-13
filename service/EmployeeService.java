package employee.javaFileIO.service;

import employee.javaFileIO.entity.EmployeePayroll;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployeeService {
    public void run() throws IOException {
        System.out.println("Employee Payroll Service: ");
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.readFromConsole();
        System.out.println("Employee Details: ");
        employeePayroll.writeToConsole();
        writeInFile(employeePayroll);
        printPayrollFile();
        showEntries();
        readFile();
    }

    private void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("G:\\GE-work\\employeePayroll\\src\\main\\java\\employee\\javaFileIO\\employee.txt"));
        String line;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
    }

    /**
     * Count entries in employee.txt
     * @throws IOException
     */
    private void showEntries() throws IOException {
        long cnt = Files.lines(Paths.get("G:\\GE-work\\employeePayroll\\src\\main\\java\\employee\\javaFileIO\\employee.txt")).count();
        System.out.println("Entries are : "+cnt);
    }

    private void printPayrollFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("G:\\GE-work\\employeePayroll\\src\\main\\java\\employee\\javaFileIO\\employee.txt"));
        String line;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
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
