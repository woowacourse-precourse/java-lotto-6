package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호는 범위를 벗어날 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateBonusNumberOutOfRange(int ourRangeNumber) {
        // given

        // when, then
        assertThatThrownBy(() -> BonusNumber.of(ourRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplicated() {
        // given
        int duplicatedNumber = 1;
        BonusNumber duplicatedBonusNumber = BonusNumber.of(duplicatedNumber);

        // when, then
        assertThatThrownBy(() -> duplicatedBonusNumber.validateBonusNumberDuplicated(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATION.getMessage());
    }
}