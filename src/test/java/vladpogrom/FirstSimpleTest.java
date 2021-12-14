package vladpogrom;

import org.junit.jupiter.api.*;

@DisplayName("First simple java tests")
public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("    @BeforeAll method!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("        @BeforeEach method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("    @AfterAll method!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("        @AfterEach method!");
    }

    @DisplayName("      First test")
    @Test
    void firstTest() {
        Assertions.assertEquals(1, 1);
    }

    @DisplayName("      Second test")
    @Test
    void secondTest() {
        Assertions.assertTrue(5 > 1);
    }
}
