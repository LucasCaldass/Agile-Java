package sis.studentinfo;

import sis.report.ReportConstant;

public class RosterReporter {
    static final String ROSTER_REPORT_HEADER =
            "studentinfo.Student" + ReportConstant.NEWLINE +
            "-" + ReportConstant.NEWLINE;
    static final String ROSTER_REPORT_FOOTER =
            ReportConstant.NEWLINE + "# students = ";

    private CourseSession session;

    RosterReporter(CourseSession session) {
        this.session = session;
    }

    String getReport() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(ROSTER_REPORT_HEADER);

        for(Student student : session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(ReportConstant.NEWLINE);
        }

        buffer.append(
                ROSTER_REPORT_FOOTER + session.getAllStudents().size() + ReportConstant.NEWLINE
        );

        return buffer.toString();
    }
}
