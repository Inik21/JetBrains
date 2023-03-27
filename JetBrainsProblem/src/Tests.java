import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void allEqualTest() {
        int hoursToStudy = 5;
        int topics = 5;
        int[] times = {0,1,2,3,4,5};
        int[] questionsOnExam = {0,1,2,3,4,5};
        int expected = 5;
        int actual = Main.prepareForExam(hoursToStudy, topics, times, questionsOnExam);
        assertEquals(expected,actual);
    }

    @Test
    void betterCombinationTest() {
        int hoursToStudy = 5;
        int topics = 3;
        int[] times = {0,5,4,1};
        int[] questionsOnExam = {0,10,3,8};
        int expected = 11;
        int actual = Main.prepareForExam(hoursToStudy, topics, times, questionsOnExam);
        assertEquals(expected,actual);
    }

    @Test
    void betterQuestionsPerHourTest() {
        int hoursToStudy = 4;
        int topics = 3;
        int[] times = {0,5,4,1};
        int[] questionsOnExam = {0,10,3,8};
        int expected = 8;
        int actual = Main.prepareForExam(hoursToStudy, topics, times, questionsOnExam);
        assertEquals(expected,actual);
    }

    @Test
    void betterSingleTopicThanCombinationTest() {
        int hoursToStudy = 3;
        int topics = 3;
        int[] times = {0,3,2,1};
        int[] questionsOnExam = {0,12,1,5};
        int expected = 12;
        int actual = Main.prepareForExam(hoursToStudy, topics, times, questionsOnExam);
        assertEquals(expected,actual);
    }
}