package pt.iade.unimanage.models;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
    private static int nextNumber = 0;
    private String name;
    private LocalDate birthDate;
    private String email;
    private char gender;
    private int number;
    public Student(String name, LocalDate birthDate,
                   char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = nextNumber;
        nextNumber++;
        email = "";
    }
    public static int getNextNumber() { return nextNumber; }
    public String getName() {  
        if (gender == 'M')
            return "Mr. "+name;
        else return "Mrs. "+name;     
    }
    public void setName(String name) { this.name = name; }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNumber() {
        return number;
    }        
    public String getEmail() {
        return email;
    }
    public int getAge() {
        LocalDate today = LocalDate.now();
        return today.getYear() - birthDate.getYear();
    }
    @JsonIgnore
    public char getGender() {
        return gender;
    }
}
