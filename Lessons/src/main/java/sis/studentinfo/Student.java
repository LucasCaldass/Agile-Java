package sis.studentinfo;

import java.util.*;

public class Student {
    private boolean isHonors = false;
    enum Grade {A, B, C, D, F};
    private ArrayList<Grade> grades = new ArrayList<>();
    static final String IN_STATE = "CO";
    private String name;
    private int credits;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private String state = "";
    public Student(String name) {
        this.name = name;
        credits = 0;
    }
    public String getName(){
        return name;
    }

    boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    int getCredits() {
        return credits;
    }

    void addCredits(int credits) {
        this.credits += credits;
    }

    void setState(String state) {
        this.state = state;
    }

    boolean isInState() {
        return state.equals(Student.IN_STATE);
    }

    void addGrade(Grade grade) {
        grades.add(grade);
    }

    double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradePointsFor(grade);
        }
        return total / grades.size();
    }

    int gradePointsFor(Grade grade) {
        int points = basicGradePointsFor(grade);
        if (isHonors)
            if (points > 0)
                points += 1;
        return points;
    }

    private int basicGradePointsFor(Grade grade) {
        if (grade == Grade.A) return 4;
        if (grade == Grade.B) return 3;
        if (grade == Grade.C) return 2;
        if (grade == Grade.D) return 1;
        return 0;
    }

    void setHonors() {
        isHonors = true;
    }

}
