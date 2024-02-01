package sis.report;

import org.junit.Assert;
import org.junit.Test;
import sis.RosterReporter;
import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

import static sis.report.ReportConstant.NEWLINE;

import static sis.studentinfo.DateUtil.createDate;

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
