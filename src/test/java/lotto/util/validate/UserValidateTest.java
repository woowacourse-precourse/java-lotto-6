package lotto.util.validate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserValidateTest {

    @DisplayName("사용자가 입력한 구매금액이 1000단위인지 확인")
    @Test
    void 구매금액_1000단위_확인(){
        assertThatThrownBy(() -> UserValidate.isTousand(12345))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
