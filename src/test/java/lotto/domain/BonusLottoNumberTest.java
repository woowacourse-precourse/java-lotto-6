package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusLottoNumberTest {
    @DisplayName("보너스 숫자가 범위에서 벗어나 있으면 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 46})
    void createLottoByDuplicatedNumber(Integer bonusLottoNumber) {
        assertThatThrownBy(() -> new BonusLottoNumber(bonusLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}