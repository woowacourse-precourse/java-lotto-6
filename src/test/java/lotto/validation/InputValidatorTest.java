package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void moneyValidate() {
        String input1 = "900"; //1000원 미만 숫자 입력
        String input2 = "abc"; //정수 이외의 입력
        String input3 ="1500"; //1000원으로 나누어 떨어지지 않는 입력

        assertThrows(IllegalArgumentException.class, ()->{
           InputValidator.moneyValidate(input1);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input2);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input3);
        });
    }

    @Test
    void winningValidate() {
        String[] input1 = "1,2,,3,4,5,6".split("," ,-1);
        String[] input3 = {"1", "2", "3", "4", "5", "abc"}; // 정수이외 입력

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input1);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input3);
        });
    }

    @Test
    void bonusValidate() {
        String input1 = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.bonusValidate(input1);
        });
    }
}