package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
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

    @Test
    @DisplayName("유저가 산 로또와 당첨 로도 번호를 비교하여 등수를 저장")
    void saveLottoRankResult() {
        Lotto winningLotto = new Lotto(List.of(1, 10, 15, 20, 25, 30));
        Integer bonusNumber = 5;
        User user = new User("2000");
        assertDoesNotThrow(() -> {
            user.saveLottoRankResult(winningLotto, bonusNumber);
        });
    }
}