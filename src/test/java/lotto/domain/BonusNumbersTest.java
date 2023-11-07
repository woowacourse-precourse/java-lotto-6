package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumbersTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("주어진 보너스 번호의 개수가 일치하지 않을 경우 예외 발생")
    void testValidate() {
        // given
        List<Integer> bonus = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            bonus.add(i);
        }
        List<Integer> wrongBonus = new ArrayList<>(bonus);
        wrongBonus.add(LOTTO_NUMBER_MAX.getNum());

        // when
        BonusNumbers bonusNumbers = new BonusNumbers(bonus);

        // then
        assertThatThrownBy(() -> bonusNumbers.validate(wrongBonus))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> bonusNumbers.validate(bonus)).doesNotThrowAnyException();

    }
}