package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어난_보너스번호를_입력하면_예외가_발생한다(int input) {
        // when & then
        assertThatThrownBy(() -> {
            new BonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }
}