package sis.studentinfo;

import java.io.Serializable;

public interface GradingStrategy {
    int getGradePointsFor(Student.Grade grade);
}
