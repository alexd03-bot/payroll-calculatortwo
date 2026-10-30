package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class EmployeeReader {
    public static void main(String[] args) {

        String fileName = "src/main/resources/employees.csv";


        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffRead = new BufferedReader(fileReader);

            String line = buffRead.readLine();
            line = buffRead.readLine();

            while (line != null) {
                Employee employee = parseEmployee(line);

                System.out.printf("%d  %s  %.2f\n",
                        employee.getEmployeeId(), employee.getName(), employee.getHoursWorked());
                line = buffRead.readLine();
            }
            buffRead.close();
//try close v
        } catch (FileNotFoundException e) {
            System.out.println("doesn't exist");
        } catch (IOException e) {
            System.out.println("placeholder");
        }


    }//psvm close

    public static Employee parseEmployee(String employeeCsv) {
        String[] lineParts = employeeCsv.split(Pattern.quote("|"));
        int id = Integer.parseInt(lineParts[0]);
        String name = lineParts[1];
        double hoursWorked = Double.parseDouble(lineParts[2]);
        double payRate = Double.parseDouble(lineParts[3]);

        Employee employee = new Employee(id, name, hoursWorked, payRate);

        return employee;
    }//parseemp close




















}//class end
