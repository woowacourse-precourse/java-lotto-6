package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("예외 처리 테스트")
public class ExceptionValidatorTest {

    @Test
    @DisplayName("입력받은 금액이 숫자가 아닌 경우")
    void 입력받은_금액에_문자가_포함된경우() {
        assertThatThrownBy(() -> new Validator().checkMoneyInput("100-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_금액이_문자() {
        assertThatThrownBy(() -> new Validator().checkMoneyInput("abce"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액에_공백이_입력된_경우() {
        assertThatThrownBy(() -> new Validator().checkMoneyInput(" 1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호에_공백이_입력된_경우() {
        assertThatThrownBy(() -> new Validator().checkNotNumberAndSpace("1,2,34, 5,4,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호에_문자가_입력된_경우() {
        assertThatThrownBy(() -> new Validator().checkNotNumberAndSpace("1,2,a,5,4,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
