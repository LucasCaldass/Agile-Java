
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

public class CourseSessionTest {
    private CourseSession session;

    public void setUp() {
        CourseSession session = new CourseSession("ENGL", "101");
    }
    @Test
    public void testCreate() {
        Assert.assertEquals("ENGL", session.getDepartment());
        Assert.assertEquals("101", session.getNumber());
        Assert.assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollStudents() {

        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        Assert.assertEquals(1, session.getNumberOfStudents());
        ArrayList <Student> allStudents = session.getAllStudents();
        Assert.assertEquals(1, allStudents.size());
        Assert.assertEquals(student1, allStudents.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        Assert.assertEquals(2,session.getNumberOfStudents());
        Assert.assertEquals(2, allStudents.size());
        Assert.assertEquals(student1, allStudents.get(0));
        Assert.assertEquals(student2, allStudents.get(0));
    }
}
