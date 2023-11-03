package lotto.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private String ERROR = "[ERROR]";
    private static final String NULL_ERROR_MESSAGE = "금액을 입력해주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private InputMoneyValidator inputMoneyValidator;

    @Test
    void 값_미전달_예외_처리_테스트(){
        String input = "";
        assertThatThrownBy(() -> inputMoneyValidator = new InputMoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NULL_ERROR_MESSAGE);
    }

    @Test
    void 입력_값_숫자_판별_예외_처리_테스트(){
        String input = "adsf";
        assertThatThrownBy(() -> inputMoneyValidator = new InputMoneyValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR+NOT_NUMBER_ERROR_MESSAGE);
    }

}
