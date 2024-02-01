package sis.summer;
import junit.framework.*;
import java.util.*;
import sis.studentinfo.*;
public class SummerCourseSessionTest extends SessionTest {
    @org.junit.Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL", "200", startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        Assert.assertEquals(eightWeeksOut, session.getEndDate());
    }

    protected Session createSession(
            String department,
            String number,
            Date date) {
        return SummerCourseSession.create(department, number, date);
    }
}
