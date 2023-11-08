package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    private static final String IS_THOUSAND_UNIT_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
    private static final String IS_MINIMUM_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력 금액은 최소 0원보다 커야 합니다.";
    @ParameterizedTest
    @ValueSource(ints = {0,-1,-2})
    @DisplayName("금액_객체_생성시_최소_금액_불만족_테스트")
    void invalid_minimumAmountTest(Integer amount){
        // given
        // when & then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_MINIMUM_VALIDATOR_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {400,8500,5880})
    @DisplayName("금액_객체_생성시_1000원_단위_불만족_테스트")
    void invalid_moneyUnitTest(Integer amount){
        // given
        // when & then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_THOUSAND_UNIT_VALIDATOR_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {8000,14000,55000})
    @DisplayName("금액_객체_생성시_1000원_단위_불만족_테스트")
    void valid_moneyUnitTest(Integer amount){
        // given
        Money money = new Money(amount);
        // when
        Integer answerAmount = money.getAmount();
        // then
        assertThat(answerAmount).isEqualTo(amount);
    }
}