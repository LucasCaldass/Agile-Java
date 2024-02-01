package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.RosterReporterTest;
import sis.studentinfo.*;

@RunWith(Suite.class) @Suite.SuiteClasses({
        StudentTest.class,
        CourseSessionTest.class,
        RosterReporterTest.class,
        DateUtilTest.class,
        BasicGradingStrategyTest.class,
        HonorsGradingStrategyTest.class,
        PerformanceTest.class,
        ScorerTest.class
})
public class AllTests{}
