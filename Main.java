package employee.javaFileIO;

import employee.javaFileIO.service.EmployeeService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeService service = new EmployeeService();
        service.run();
    }
}
