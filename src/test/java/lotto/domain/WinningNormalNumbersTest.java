package lotto.domain;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.global.constant.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNormalNumbersTest {
    WinningNormalNumbers winningNormalNumbers;

    @BeforeEach
    void setUp() {
        winningNormalNumbers = new WinningNormalNumbers();
    }

    @Test
    void winningNormalNumbers가_숫자를_잘생성하는지_확인() {
        String numbers = "1,2,3,4,5,6";

        winningNormalNumbers.generateWinningNormalNumbers(numbers);
        List<WinningNumber> winningNumbers = winningNormalNumbers.getWinningNumbers();

        List<Integer> numbersResult = winningNumbers.stream()
                .map(WinningNumber::getNumber).toList();

        assertThat(numbersResult)
                .containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 숫자가_중복일때_예외던지는지_확인() {
        String numbers = "1,2,2,4,5,6";

        assertThatThrownBy(() -> winningNormalNumbers.generateWinningNormalNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATED.getMessage());

    }

    @Test
    void 숫자가_6개_이상일때__예외던지는지_확인() {
        String numbers = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> winningNormalNumbers.generateWinningNormalNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_COUNT_MUST_BE_SIX.getMessage());

    }

    @Test
    void 보너스_숫자와_중복시_예외던지는지_확인() {
        String numbers = "1,2,3,4,5,6";
        BonusNumber bonusNumber = new BonusNumber();
        bonusNumber.generateBonusNumber("6");

        winningNormalNumbers.generateWinningNormalNumbers(numbers);

        assertThatThrownBy(() -> winningNormalNumbers.validateBonusIsDuplicateWithWinningNormalNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATED.getMessage());

    }
}
