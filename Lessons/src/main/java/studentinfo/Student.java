package studentinfo;

public class Student {
    private String name;
    private int credits;
    public Student(String name) {
        this.name = name;
        credits = 0;
    }
    public String getName(){
        return name;
    }

    boolean isFullTime() {
        return false;
    }

    int getCredits() {
        return credits;
    }

    void addCredits(int credits) {
        this.credits += credits;
    }
}
