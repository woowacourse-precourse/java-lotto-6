package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("예외 처리 테스트")
public class ExceptionValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("입력받은 금액이 숫자가 아닌 경우")
    void 입력받은_금액에_문자가_포함된경우() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> new Validator().checkMoneyInput("100-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액이_문자() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> new Validator().checkMoneyInput("abce"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이_입력된_경우() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> new Validator().checkMoneyInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
