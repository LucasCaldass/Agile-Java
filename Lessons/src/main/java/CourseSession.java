import java.util.*;

public class CourseSession {
    private final String department;
    private final String number;
    private final ArrayList <Student> students = new ArrayList<>();
    private Date startDate;

    public CourseSession(String department, String number, Date starDate) {
        this.department = department;
        this.number = number;
        this.startDate = starDate;
    }

    String getDepartment() {
        return department;
    }

    String getNumber() {
        return number;
    }

    int getNumberOfStudents() {
        return students.size();
    }

    void enroll(Student student) {
        students.add(student);
    }

    ArrayList<Student> getAllStudents() {
        return students;
    }

    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    Date getStartDate() {
        return startDate;
    }
}
