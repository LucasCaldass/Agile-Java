import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;

public class RosterReporterTest {
    public void testRosterReport() {
        CourseSession session = new CourseSession("ENGL", "101", createDate(2003, 1, 6));

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        String rosterReport = new RosterReporter(session).getReport();
        Assert.assertEquals(
                CourseSession.ROSTER_REPORT_HEADER +
                        "A" + RosterReporter.NEWLINE +
                        "B" + RosterReporter.NEWLINE +
                        RosterReporter.ROSTER_REPORT_FOOTER + "2" +
                        RosterReporter.NEWLINE, rosterReport);
    }
}
