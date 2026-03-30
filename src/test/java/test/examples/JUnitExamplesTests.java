package test.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll
    static void startUp () {
        System.out.println("test startup");
    }

    @AfterAll
    static void startdown () {
        System.out.println("test ended");
    }

    @AfterEach
    void stopBrowser() {
        System.out.println("- browser has stopped");
    }

    @Test
    void firstTest() {
        System.out.println("+ firstTest");
    }

    @Test
    void secondsTest() {
        System.out.println("+ secondsTest");
    }

}
