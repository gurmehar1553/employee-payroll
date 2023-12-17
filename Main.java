package employee.javaFileIO;

import employee.javaFileIO.service.EmployeeService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeService service = new EmployeeService();
        service.run();
        String path ="G:\\GE-work\\employeePayroll\\src\\main\\java\\employee\\javaFileIO";
        if(checkFileExists(path)){
            System.out.println("File Exists");
            deleteFile(path);
        }
        else {
            System.out.println("File Does not exist");
        }
        createDirectory(path);
        createEmptyFile(path);
        listFilesDir(path);
        listFilesWithExtension(path);
        new WatchServiceDemo(Paths.get(path)).processEvents();
    }

    /**
     * List all files with extensions
     * @param path
     */
    public static void listFilesWithExtension(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        System.out.println("Files with extensions: ");
        for (File f:files){
            if (f.getName().indexOf('.')!=-1){
                System.out.println(f.getName());
            }
        }
    }

    public static void listFilesDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        System.out.println("Names of Files and Directories");
        for (File f:files){
            System.out.println(f.getName());
        }
    }

    public static void createEmptyFile(String path) throws IOException {
        File file = new File(path+"\\demoFile.txt");
        if(file.createNewFile()){
            System.out.println("Empty File Created");
        }
    }

    public static void createDirectory(String path) {
        File dir = new File(path+"\\demoDir");
        if(dir.mkdir()){
            System.out.println("Empty Directory Created");
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path+"\\DemoFile.txt");
        if (file.delete()){
            System.out.println("File Deleted");
        }
        else {
            System.out.println("Unable to delete file");
        }
    }

    public static boolean checkFileExists(String path) {
        File file = new File(path+"\\DemoFile.txt");
        return file.exists();
    }
}
