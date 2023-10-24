package sis.studentinfo;

import org.junit.*;
import sis.studentinfo.Student;

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

    public void testInState() {
        Student student = new Student("a");
        Assert.assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        Assert.assertTrue(student.isInState());
        student.setState("MD");
        Assert.assertFalse(student.isInState());

    }
}
