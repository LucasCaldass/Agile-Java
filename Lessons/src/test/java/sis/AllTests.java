package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.*;
import sis.summer.SummerCourseSessionTest;
import sis.ui.StudentUITest;

@RunWith(Suite.class) @Suite.SuiteClasses({

        //Student Tests
        StudentTest.class,
        PerformanceTest.class,
        ScorerTest.class,
        StudentDirectoryTest.class,
        ReportCardTest.class,
        StudentUITest.class,

        //CourseTests
        //suite.addTestSuite(SessionTest.class)
        CourseTest.class,
        CourseSessionTest.class,
        CourseReportTest.class,
        RosterReporterTest.class,

        BasicGradingStrategyTest.class,

        HonorsGradingStrategyTest.class,
        SummerCourseSessionTest.class,
        CourseCatalogTest.class,

        //DataBase Tests

        DateUtilTest.class,

        PerformanceTest.class,

})
public class AllTests{}
