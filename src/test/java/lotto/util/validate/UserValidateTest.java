package lotto.util.validate;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserValidateTest {

    @DisplayName("사용자가 입력한 구매금액이 1000단위가 아닌 경우 예외 발생")
    @Test
    void 구매금액_1000단위_확인(){
        assertThatThrownBy(() -> UserValidate.isTousand(12345))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 로또 번호가 6개를 초과하는 경우 예외 발생")
    @Test
    void 로또_당첨번호_개수_확인(){
        assertThatThrownBy(() -> UserValidate.checkNumberCount(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 숫자의 범위가 1 ~ 45사이가 아니면 예외 발생")
    @Test
    void 숫자_범위_확인(){
        assertThatThrownBy(() -> UserValidate.checkNumberRange(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserValidate.checkNumberRange(46))
            .isInstanceOf(IllegalArgumentException.class);

    }

}
