package sis.report;

import junit.framework.*;
import org.junit.Assert;
import org.junit.Test;
import sis.studentinfo.*;

public class ReportCardTest {
    @Test
    public void testMessage() {
        ReportCard card = new ReportCard();
        Assert.assertEquals(ReportCard.A_MESSAGE,
                card.getMessage(Student.Grade.A));
        Assert.assertEquals(ReportCard.B_MESSAGE,
                card.getMessage(Student.Grade.B));
        Assert.assertEquals(ReportCard.C_MESSAGE,
                card.getMessage(Student.Grade.C));
        Assert.assertEquals(ReportCard.D_MESSAGE,
                card.getMessage(Student.Grade.D));
        Assert.assertEquals(ReportCard.F_MESSAGE,
                card.getMessage(Student.Grade.F));
    }
}
