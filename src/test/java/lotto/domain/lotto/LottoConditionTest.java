package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoConditionTest {

    @DisplayName("로또 숫자는 1 ~ 45 사이의 숫자만 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void isNotInRange(int invalidNumber) {
        // given & when & then
        assertThat(LottoCondition.isNotInRange(invalidNumber)).isTrue();
    }

    @DisplayName("로또의 사이즈는 6이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7})
    void isInvalidLength(int length) {
        // given & when & then
        assertThat(LottoCondition.isInvalidLength(length)).isTrue();
    }
}