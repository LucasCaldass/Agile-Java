package sis.studentinfo;

import java.util.*;

public class Student  implements Comparable<Student> {
    private GradingStrategy gradingStrategy =
            new BasicGradingStrategy();
    private boolean isHonors = false;

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);

        private int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints() {
            return points;
        }
    };

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
            total += gradingStrategy.getGradePointsFor(grade);
        }
        return total / grades.size();
    }

    void setHonors() {
        isHonors = true;
    }

    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }
}
