package lotto.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputMoneyTest {
    @Test
    void 천원단위_입력이_아닌_경우() {
        int notMatchPrice = 5_001;
        assertThatThrownBy(() -> new UserInputMoney(notMatchPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원단위_입력인_경우() {
        int matchPrice = 5000;
        UserInputMoney money = new UserInputMoney(matchPrice);
        assertEquals(matchPrice, money.getAmount());
    }
}