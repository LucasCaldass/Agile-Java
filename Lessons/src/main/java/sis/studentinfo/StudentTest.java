package sis.studentinfo;

import org.junit.*;
import sis.studentinfo.Student;

import static org.junit.Assert.fail;

public class StudentTest {

    private static final double GRADE_TOLERANCE = 0.05;

    @Test
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        Assert.assertEquals(firstStudentName, firstStudent.getName());
        Assert.assertEquals("Jane", firstStudent.getFirstName());
        Assert.assertEquals("Doe", firstStudent.getLastName());
        Assert.assertEquals("", firstStudent.getMiddleName());

        final String secondStudentName = "Blow";
        Student secondStudent = new Student(secondStudentName);
        Assert.assertEquals(secondStudentName, secondStudent.getName());
        Assert.assertEquals("", secondStudent.getFirstName());
        Assert.assertEquals("Blow", secondStudent.getLastName());
        Assert.assertEquals("", secondStudent.getMiddleName());

        final String thirdStudentName = "Raymond Douglas Davies";
        Student thirdStudent = new Student(thirdStudentName);
        Assert.assertEquals(thirdStudentName, thirdStudent.getName());
        Assert.assertEquals("Raymond", thirdStudent.getFirstName());
        Assert.assertEquals("Davies", thirdStudent.getLastName());
        Assert.assertEquals("Douglas", thirdStudent.getMiddleName());
    }

    @Test
    public void testFullTime() {
        Student student = new Student("a");
        Assert.assertFalse(student.isFullTime());
    }

    @Test
    public void testCredits() {
        Student student = new Student("a");
        Assert.assertEquals(0, student.getCredits());
        student.addCredits(3);
        Assert.assertEquals(3, student.getCredits());
        student.addCredits(4);
        Assert.assertEquals(7, student.getCredits());
    }

    @Test
    public void testStudentStatus() {
        Student student = new Student("a");
        Assert.assertEquals(0, student.getCredits());
        Assert.assertFalse(student.isFullTime());

        student.addCredits(3);
        Assert.assertEquals(3, student.getCredits());
        Assert.assertFalse(student.isFullTime());

        student.addCredits(4);
        Assert.assertEquals(7, student.getCredits());
        Assert.assertFalse(student.isFullTime());

        student.addCredits(5);
        Assert.assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        Assert.assertTrue(student.isFullTime());
    }

    @Test
    public void testInState() {
        Student student = new Student("a");
        Assert.assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        Assert.assertTrue(student.isInState());
        student.setState("MD");
        Assert.assertFalse(student.isInState());
    }

    @Test
    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    private void assertGpa(Student student, double expectedGpa) {
        Assert.assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    @Test
    public void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
    }

    private Student createHonorsStudent(Student.Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }
    @Test
    public void testCharges() {
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(200);
        student.addCharge(399);
        Assert.assertEquals(1099, student.totalCharges());
    }

    @Test
    public void testBadlyFormattedName() {
        try {
            new Student("a b c d");
            fail("expected exception from 4-part name");
        }
        catch (StudentNameFormatException expectedException) {
            Assert.assertEquals(
                    "Student name 'a b c d' contains more than 3 parts",
                    expectedException.getMessage()
            );
        }
    }

}
