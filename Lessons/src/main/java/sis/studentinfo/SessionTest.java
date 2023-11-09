package sis.studentinfo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

}
