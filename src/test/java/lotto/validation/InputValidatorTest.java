package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void moneyValidate() {
        String input1 = "900"; //1000원 미만 숫자 입력
        String input2 = "abc"; //정수 이외의 입력
        String input3 = "1000"; //정상 입력
        String input4 ="1500"; //1000원으로 나누어 떨어지지 않는 입력

        assertThrows(IllegalArgumentException.class, ()->{
           InputValidator.moneyValidate(input1);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input2);
        });

        InputValidator.moneyValidate(input3);

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.moneyValidate(input4);
        });
    }

    @Test
    void winningValidate() {
        String[] input1 = {"1", "2", "4", "5", "6"}; //공백 입력
        String[] input2 = {"1", "2", "3", "4", "5", "5"}; //중복입력
        String[] input3 = {"1", "2", "3", "4", "5", "abc"}; // 정수이외 입력
        String[] input4 = {"1", "2", "3", "4", "5", "600"}; //범위 초과
        String[] input5 = {"1", "2", "3", "4", "5", "6"}; //정상 입력

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input1);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input2);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input3);
        });

        assertThrows(IllegalArgumentException.class,()->{
            InputValidator.winningValidate(input4);
        });

        InputValidator.winningValidate(input5);
    }

    @Test
    void bonusValidate() {
        String input1 = "abc";
        String input2 = "45";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.bonusValidate(input1);
        });

        InputValidator.bonusValidate(input2);
    }
}