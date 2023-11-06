package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UserTest {
    User user = new User();

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2500", "3200", "16220", "87799", "5438219"})
    void inputAmountTest(String input) {
        assertThatThrownBy(() -> user.countLottoTicketIssues(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력하세요.");
    }

    @DisplayName("시도 횟수 구하는 메서드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000,2", "3000,3", "17000,17", "199000,199", "145000,145"})
    void inputMoneyTest(String input, int count) {
        int result = user.countLottoTicketIssues(input);
        assertThat(result).isEqualTo(count);
    }

}