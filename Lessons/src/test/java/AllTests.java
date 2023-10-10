

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import studentinfo.CourseSessionTest;
import studentinfo.DateUtilTest;
import studentinfo.RosterReporterTest;
import studentinfo.StudentTest;

@RunWith(Suite.class) @Suite.SuiteClasses({
        StudentTest.class,
        CourseSessionTest.class,
        RosterReporterTest.class,
        DateUtilTest.class
})
public class AllTests{}
