package studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */

public class CourseSession {
    static final String NEWLINE =
            System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER =
            "studentinfo.Student" + NEWLINE + "-" + NEWLINE;
    static final String ROSTER_REPORT_FOOTER =
            NEWLINE + "# students = ";
    private final String department;
    private final String number;
    private final ArrayList <Student> students = new ArrayList<>();
    private final Date startDate;

    public CourseSession(String department, String number, Date starDate) {

        /**
         * Constructs a studentinfo.CourseSession starting on a specific date
         *
         * @param startDate the date on which the studentinfo.CourseSession begins
         */
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

    public void enroll(Student student) {
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    /**
     * @return Date the last date of the course session
     */
    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    Date getStartDate() {
        return startDate;
    }

    public String getRosterReport() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(ROSTER_REPORT_HEADER);

        for(Student student : students) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }

        buffer.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);

        return buffer.toString();
    }
}
