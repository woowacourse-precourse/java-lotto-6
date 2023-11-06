package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import lotto.model.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UserLottoTest {

    @DisplayName("구입 금액이 음수일 때 예외")
    @Test
    void checkNegativeMoney() {
        assertThatThrownBy(() -> new UserLotto(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
