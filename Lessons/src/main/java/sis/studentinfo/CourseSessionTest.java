package sis.studentinfo;

import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {
    public void testCourseDates() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
        Session session = createSession("ENGL", "200", startDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        Assert.assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createSession("", "", new Date());
        Assert.assertEquals(1, CourseSession.getCount());
        createSession("", "", new Date());
        Assert.assertEquals(2, CourseSession.getCount());
    }

    protected Session createSession(
            String department,
            String number,
            Date date) {;
        return CourseSession.create(department, number, date);
    }
}