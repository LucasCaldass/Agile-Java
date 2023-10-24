package sis.studentinfo;

import org.junit.*;

import java.util.*;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest {
    private CourseSession session;
    private Date startDate;
    private static final int CREDITS = 3;

    @Before
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
    }

    @Test
    public void testCreate() {
        Assert.assertEquals("ENGL", session.getDepartment());
        Assert.assertEquals("101", session.getNumber());
        Assert.assertEquals(0, session.getNumberOfStudents());
        Assert.assertEquals(startDate, session.getStartDate());
    }

    @Test
    public void testEnrollStudents() {

        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        Assert.assertEquals(CREDITS, student1.getCredits());
        Assert.assertEquals(1, session.getNumberOfStudents());
        ArrayList <Student> allStudents = session.getAllStudents();
        Assert.assertEquals(1, allStudents.size());
        Assert.assertEquals(student1, allStudents.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        Assert.assertEquals(CREDITS, student2.getCredits());
        Assert.assertEquals(2,session.getNumberOfStudents());
        Assert.assertEquals(2, allStudents.size());

        Assert.assertEquals(student1, allStudents.get(0));
        Assert.assertEquals(student2, allStudents.get(1));
    }

    @Test
    public void testCourseDates() {
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        Assert.assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testRosterReport() {
        Student studentA = new Student("A");
        Student studentB = new Student("B");
        session.enroll(studentA);
        session.enroll(studentB);

        String rosterReport = session.getRosterReport();
        Assert.assertEquals(
                CourseSession.ROSTER_REPORT_HEADER +
                "A" + CourseSession.NEWLINE +
                "B" + CourseSession.NEWLINE +
                CourseSession.ROSTER_REPORT_FOOTER + "2" +
                CourseSession.NEWLINE, rosterReport);
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createCourseSession();
        Assert.assertEquals(1, CourseSession.getCount());
        createCourseSession();
        Assert.assertEquals(2, CourseSession.getCount());
    }

    private CourseSession createCourseSession() {
        CourseSession session =
                CourseSession.create("ENGL", "101", startDate);
        session.setNumberOfCredits(CourseSessionTest.CREDITS);
        return session;
    }
}
