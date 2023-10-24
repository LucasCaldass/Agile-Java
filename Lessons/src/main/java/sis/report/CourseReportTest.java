package sis.report;

import junit.framework.*;
import org.junit.Assert;
import sis.studentinfo.CourseSession;
import java.util.*;

import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest {
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("ENGL", "101", date));

        Assert.assertEquals(
                "CZEC 200" + NEWLINE +
                        "ENGL 101" + NEWLINE +
                        "ITAL 410" + NEWLINE,
                report.text());
    }
}
