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
        List<String> nameParts = Arrays.asList(fullName.split(" "));
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

    /*private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);

        if (nameParts.isEmpty()) {
            this.firstName = name;
        }
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }*/

    private String removeLast(List<String> list) {
        if(list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }

    /*private List<String> tokenize(String string) {
        List<String> results = new ArrayList<String>();
        StringBuffer word = new StringBuffer();
        int index = 0;
        while (index < string.length()) {
            char ch = string.charAt(index);
            if (ch != ' ') word.append(ch);
            else
                if (word.length() > 0) {
                    results.add(word.toString());
                    word = new StringBuffer();
                }
            index++;
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }*/
}
