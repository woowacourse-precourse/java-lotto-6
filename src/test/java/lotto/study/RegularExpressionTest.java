package lotto.study;

import org.junit.jupiter.api.Test;

public class RegularExpressionTest {

    @Test
    void 정규식_테스트() {
        String input = "12";
        String input2 = "";

        System.out.println(input.matches("^[0-9]*$"));
        System.out.println(input.matches("^\\d+$"));
        System.out.println(input2.matches("^[0-9]*$"));
        System.out.println(input2.matches("^\\d+$"));
    }

}
