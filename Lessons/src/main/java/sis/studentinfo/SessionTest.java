package sis.studentinfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.*;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest {
    private Session session;
    private Date startDate;
    public static final int CREDITS = 3;

    @Before
    public void setUp() {
        startDate = createDate(2003, 1, 6);
        session = createSession("ENGL", "101", startDate);
        session.setNumberOfCredits(CREDITS);
    }

    abstract protected Session createSession(
            String department, String number, Date startDate);

    @Test
    public void testCreate() {
        Assert.assertEquals("ENGL", session.getDepartment());
        Assert.assertEquals("101", session.getNumber());
        Assert.assertEquals(0, session.getNumberOfStudents());
        Assert.assertEquals(startDate, session.getStartDate());
    }

    @Test
    public void testComparable() {
        final Date date = new Date();
        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);
        Assert.assertTrue(sessionA.compareTo(sessionB) < 0);
        Assert.assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession("CMSC", "101", date);
        Assert.assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession("CMSC", "210", date);
        Assert.assertTrue(sessionC.compareTo(sessionD) < 0);
        Assert.assertTrue(sessionD.compareTo(sessionC) > 0);
    }

    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        Assert.assertEquals(CREDITS, student1.getCredits());
        Assert.assertEquals(1, session.getNumberOfStudents());
        Assert.assertEquals(student1, session.get(0));
        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        Assert.assertEquals(CREDITS, student2.getCredits());
        Assert.assertEquals(2, session.getNumberOfStudents());
        Assert.assertEquals(student1, session.get(0));
        Assert.assertEquals(student2, session.get(1));
    }
    @Test
    public void testAverageGpaForPartTimeStudents() {
        session.enroll(createFullTimeStudent());

        Student partTimer1 = new Student("1");
        partTimer1.addGrade(Student.Grade.A);
        session.enroll(partTimer1);

        session.enroll(createFullTimeStudent());

        Student partTimer2 = new Student("2");
        partTimer2.addGrade(Student.Grade.B);
        session.enroll(partTimer2);
        Assert.assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    }

    private Student createFullTimeStudent() {
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }

    @Test
    public void testIterate() {
        enrollStudents(session);

        List<Student> results = new ArrayList<Student>();
        for (Student student: session)
            results.add(student);

        Assert.assertEquals(session.getAllStudents(), results);
    }

    private void enrollStudents(Session session) {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }

    @Test
    public void testCasting() {
        List students = new ArrayList();
        students.add(new Student("a"));
        students.add(new Student("b"));

        List names = new ArrayList();

        Iterator it = students.iterator();
        while (it.hasNext()) {
            Student student = (Student)it.next();
            names.add(student.getLastName());
        }

        Assert.assertEquals("a", names.get(0));
        Assert.assertEquals("b", names.get(1));
    }

    @Test
    public void testSessionUrl() throws MalformedURLException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        Assert.assertEquals(url, session.getUrl().toString());
    }

    @Test
    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
            Assert.fail("expected exception due to invalid protocol in URL");
        }
        catch (MalformedURLException success) {
        }
    }

}
