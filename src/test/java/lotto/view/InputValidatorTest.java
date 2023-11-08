package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("입력이 문자가 들어올 경우 예외 발생 테스트")
    void inputNotNumberTest(){
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> {
           inputValidator.validateInputType(input);
        });
    }

    @Test
    @DisplayName("로또 번호를 입력할 때 1 이상 45 이하가 아닌 경우 예외 발생 테스트")
    void inputNotLottoNumberRange(){
        int input = 47;

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateInputNumberRange(input);
        });
    }

    @Test
    @DisplayName("로또 구입 금액을 입력할 때 1000원 단위가 아닌 경우 예외 발생 테스트")
    void inputNotLottoPurchaseAmountUnit(){
        int input = 1111;

        assertThrows(IllegalArgumentException.class, () -> {
           inputValidator.validateInputAmountUnit(input);
        });
    }
}