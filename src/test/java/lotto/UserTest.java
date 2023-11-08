package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumber() {
        User user = new User();
        int actualNumber = user.getMoneyNumber("11000");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액 1,000원 단위가 아닌 경우")
    @Test
    void getMoneyNumberError() {
        User user = new User();
        assertThatThrownBy(() -> user.getMoneyNumber("11110"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}