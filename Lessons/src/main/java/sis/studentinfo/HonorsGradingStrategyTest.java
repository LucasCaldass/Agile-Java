package sis.studentinfo;

import org.junit.Assert;
import org.junit.Test;

public class HonorsGradingStrategyTest {
    @Test
    public void testGetGradePoints() {
        GradingStrategy strategy = new HonorsGradingStrategy();
        Assert.assertEquals(5, strategy.getGradePointsFor(Student.Grade.A));
        Assert.assertEquals(4, strategy.getGradePointsFor(Student.Grade.B));
        Assert.assertEquals(3, strategy.getGradePointsFor(Student.Grade.C));
        Assert.assertEquals(2, strategy.getGradePointsFor(Student.Grade.D));
        Assert.assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}
