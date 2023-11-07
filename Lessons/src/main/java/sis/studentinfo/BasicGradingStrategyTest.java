package sis.studentinfo;

import junit.framework.*;
import org.junit.Assert;
import org.junit.Test;

public class BasicGradingStrategyTest {
    @Test
    public void testGetGradePoints() {
        BasicGradingStrategy strategy = new BasicGradingStrategy();
        Assert.assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
        Assert.assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
        Assert.assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
        Assert.assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
        Assert.assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}
