package sis.studentinfo;

import java.util.*;
import static org.junit.Assert.*;
import static sis.studentinfo.DateUtil.createDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
    @Test
    public void testCreateDate() {
        Date date = createDate(2000, 1, 1);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Assert.assertEquals(2000, calendar.get(Calendar.YEAR));
        Assert.assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        Assert.assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }
}
