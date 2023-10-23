package studentinfo;

import org.junit.Assert;
import org.junit.Test;
import static studentinfo.report.ReportConstant.NEWLINE;

import java.util.*;

import static studentinfo.DateUtil.createDate;

public class RosterReporterTest {

    @Test
    public void testRosterReport() {
        CourseSession session = CourseSession.create("ENGL", "101", createDate(2003, 1, 6));

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        String rosterReport = new RosterReporter(session).getReport();
        Assert.assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER +
                        "A" + NEWLINE +
                        "B" + NEWLINE +
                        RosterReporter.ROSTER_REPORT_FOOTER + "2" +
                        NEWLINE, rosterReport);
    }
}
