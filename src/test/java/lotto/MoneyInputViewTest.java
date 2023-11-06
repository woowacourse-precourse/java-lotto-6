package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyInputViewTest {

    @Test
    void multiple_zero() {
        String input = "000";
        if (Integer.parseInt(input) == 0) {
            System.out.println("0을 간주");
        }
    }

    @Test
    void least_one_lotto() {

    }

}