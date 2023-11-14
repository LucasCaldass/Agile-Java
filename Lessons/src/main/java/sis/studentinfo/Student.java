package sis.studentinfo;

import java.util.*;

public class Student  implements Comparable<Student> {

    private String firstName = "";
    private String middleName = "";
    private String lastName;
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
    public Student(String fullName) {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        setName(nameParts);
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

    private List<Integer> charges = new ArrayList<Integer>();

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

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);

        if (nameParts.isEmpty()) {
            this.firstName = name;
        }
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();
        for (String name: fullName.split(" "))
            results.add(name);
        return results;
    }

    public static int countChars(String input, char ch) {
        int count;
        int i;
        for (i = 0, count = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch)
                count++;
        }
        return count;
    }

    public static boolean isPalindrome(String string) {
        if (string.length() == 0)
            return true;
        int limit = string.length()/2;
        for (int forward = 0, backward = string.length() - 1; forward < limit; forward++, backward--)
            if (string.charAt(forward) != string.charAt(backward))
                return false;
        return true;
    }

    public void addCharge(int charge) {
        charges.add(charge);
    }

    public int totalCharges() {
        int total = 0;
        for (int charge: charges)
            total += charge;
        return total;
    }

}
