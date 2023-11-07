package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.IntegerConstants;
import lotto.domain.LottoBonus;
import lotto.domain.LottoWinning;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusTest {
    @DisplayName("winning 과 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void testDuplicatedValue() {
        var winnings = new LottoWinning(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoBonus(winnings, 1))
                .isInstanceOf(DuplicateException.class);
        assertThatThrownBy(() -> new LottoBonus(winnings, 2))
                .isInstanceOf(DuplicateException.class);
        assertThatThrownBy(() -> new LottoBonus(winnings, 3))
                .isInstanceOf(DuplicateException.class);
        assertThatThrownBy(() -> new LottoBonus(winnings, 4))
                .isInstanceOf(DuplicateException.class);
        assertThatThrownBy(() -> new LottoBonus(winnings, 5))
                .isInstanceOf(DuplicateException.class);
        assertThatThrownBy(() -> new LottoBonus(winnings, 6))
                .isInstanceOf(DuplicateException.class);
    }

    @DisplayName("올바르지 않은 범위의 수가 들어오면 예외가 발생한다")
    @Test
    void testInvalidValue() {
        var winnings = new LottoWinning(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoBonus(winnings, IntegerConstants.LOTTO_RANGE_START - 1))
                .isInstanceOf(InvalidNumberException.class);

        assertThatThrownBy(() -> new LottoBonus(winnings, IntegerConstants.LOTTO_RANGE_END + 1))
                .isInstanceOf(InvalidNumberException.class);
    }
}
