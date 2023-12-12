package employee.javaFileIO.service;

import employee.javaFileIO.entity.EmployeePayroll;

import java.io.IOException;

public class EmployeeService {
    public void run() throws IOException {
        System.out.println("Employee Payroll Service: ");
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.readFromConsole();
        System.out.println("Employee Details: ");
        employeePayroll.writeToConsole();
    }
}
