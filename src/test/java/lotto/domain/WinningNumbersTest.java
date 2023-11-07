package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("주어진 당첨 번호의 개수가 일치하지 않을 경우 예외 발생")
    void testValidate() {
        // given
        List<Integer> winning = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            winning.add(i);
        }
        List<Integer> wrong = new ArrayList<>(winning);
        wrong.add(LOTTO_NUMBER_MAX.getNum());

        // when
        BonusNumbers winningNumbers = new BonusNumbers(winning);

        // then
        assertThatThrownBy(() -> winningNumbers.validate(wrong))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> winningNumbers.validate(winning)).doesNotThrowAnyException();

    }
}