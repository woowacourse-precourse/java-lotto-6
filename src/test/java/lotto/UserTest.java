package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    private Lotto WINNING_LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));


    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @DisplayName("보너스 숫자가 이상하면 오류가 발생한다.")
    @Test
    void validateBonusNumberTest() {
        assertThatThrownBy(() -> user.validateBonusNumber(WINNING_LOTTO, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.validateBonusNumber(WINNING_LOTTO, -4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.validateBonusNumber(WINNING_LOTTO, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 돈이 1000원 단위가 아니면 오류가 발생한다.")
    @Test
    void validateMoneyTest() {
        assertThatThrownBy(()->user.validateMoney(600))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->user.validateMoney(-1000))
                .isInstanceOf(IllegalArgumentException.class);

    }
}