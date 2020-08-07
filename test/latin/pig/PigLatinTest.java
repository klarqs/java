package latin.pig;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

class PigLatinTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void pigLatin() {
        System.out.println("Grace wants you to enter a phrase: ");
        Scanner input = new Scanner(System.in);
        String phrase = input.next();

        System.out.println(phrase);
    }
}
