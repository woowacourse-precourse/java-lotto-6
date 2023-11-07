package lotto.model;

import static lotto.util.message.Digit.LOTTO_RANGE_END;
import static lotto.util.message.Digit.LOTTO_RANGE_START;
import static lotto.util.message.Error.MUST_BONUS_NO_DUP_WINNING;
import static lotto.util.message.Error.MUST_LOTTO_RANGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    private final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호에 1~45범위를 넘은 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46", "77"})
    void createBonusNumberByOverRange(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(input, winningNumber))
                .withMessageContaining(
                        MUST_LOTTO_RANGE.getError(LOTTO_RANGE_START.getNumber(), LOTTO_RANGE_END.getNumber()));
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "5", "6"})
    void createBonusNumberByDuplicate(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(input, winningNumber))
                .withMessageContaining(MUST_BONUS_NO_DUP_WINNING.getError());
    }
}