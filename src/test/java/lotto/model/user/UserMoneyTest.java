package lotto.model.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.model.user.UserMoney;
import org.junit.jupiter.api.Test;

class UserMoneyTest {

    @Test
    void 로또_구입_금액이_1000원_단위로_나누어_떨어진다() {
        assertDoesNotThrow(() -> new UserMoney(12000));
    }
    @Test
    void 로또_구입_금액이_1000원_단위로_나누어_떨어지지_않을_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new UserMoney(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위입니다.");
    }
}