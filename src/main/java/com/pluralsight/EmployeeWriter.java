package com.pluralsight;

import java.io.*;

import static com.pluralsight.EmployeeReader.parseEmployee;

public class EmployeeWriter {

    public static void main(String[] args) {


        String fileName = "src/main/resources/employees.csv";
        String printTo = "src/main/resources/payroll-oct-29.csv";


        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffRead = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(printTo);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            String line = buffRead.readLine();

            Employee employee = parseEmployee(line);

            String text;
            text = String.format("%d, %s, %.2f", employee.getEmployeeId(), employee.getName(), employee.getHoursWorked());
            while (line == null) {

                fileWriter.write(text);
            }
            buffWrite.close();



            fileWriter.close();







//try close v
        } catch (FileNotFoundException e) {
            System.out.println("doesn't exist");
        } catch (IOException e) {
            System.out.println("placeholder");
        }













    }//psvm close














}//class end
