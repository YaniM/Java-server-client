package server;

import java.util.List;

public class User {
    private String email;
    private String password;
    private List<Grade> grades;

    public User(String email, String password, List<Grade> grades) {
        this.email = email;
        this.password = password;
        this.grades = grades;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
