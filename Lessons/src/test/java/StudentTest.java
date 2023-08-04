import org.junit.Test;
import org.junit.Assert;

public class StudentTest {
    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        //firstStudent.name = "June Crow";
        Assert.assertEquals(firstStudentName, firstStudent.getName());

        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        Assert.assertEquals(secondStudentName, secondStudent.getName());

        //assertEquals(firstStudentName, firstStudent.name);
    }
}
