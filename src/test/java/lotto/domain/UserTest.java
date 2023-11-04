package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @DisplayName("User 생성시 잘못된 구입 금액 입력")
    @ParameterizedTest
    @ValueSource(strings = {" ", "금액", "100", "2500"})
    void createUserByInvalidAmount(String amount) {
        assertThatThrownBy(() -> new User(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessages.INVALID_AMOUNT_MESSAGE.getMessage());

    }

    @DisplayName("User 생성시 올바른 구입 금액 입력")
    @Test
    void createUserByValidAmount() {
        String amount = "2000";
        User user = new User(amount);
        assertThat(user.getLottoTicketCount()).isEqualTo(2);
        assertThat(user.getLottos().size()).isEqualTo(2);
    }
}