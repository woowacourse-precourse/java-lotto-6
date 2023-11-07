package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerFloatingNumber {

    @DisplayName("실수의 오차")
    @Test
    void errorInFloatingNumber() {
        int integer = 13;
        double floatingNumber = (double) integer;
        System.out.println(floatingNumber);
    }
}
