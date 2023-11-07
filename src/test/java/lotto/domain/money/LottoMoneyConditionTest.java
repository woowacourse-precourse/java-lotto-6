package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyConditionTest {

    @DisplayName("1000원단위로 나누어 떨어지지 않거나 범위를 벗어난 금액을 입력하면 참을 반환합니다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 1001, 2001, 999999, 1000001})
    void isInvalidValue(int invalidPrice) {
        // given & when
        boolean isInvalidValue = LottoMoneyCondition.isInvalidValue(invalidPrice);

        // then
        assertThat(isInvalidValue).isTrue();
    }
}