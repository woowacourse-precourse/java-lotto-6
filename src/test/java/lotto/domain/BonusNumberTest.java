package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
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

    @Test
    void 보너스번호가_로또번호에_포함되었는지_확인한다() {
        // given
        BonusNumber 보너스번호 = new BonusNumber(3);
        Lotto 로또 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean 포함여부 = 보너스번호.contained(로또);

        // then
        assertEquals(true, 포함여부);
    }
}