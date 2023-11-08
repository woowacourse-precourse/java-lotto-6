package lotto.domain;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.WinningNumbers;
import lotto.global.constant.exception.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.global.constant.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(new WinningNormalNumbers(), new BonusNumber());
    }

    @Test
    void 당첨번호_생성시_잘_만들어지는지_확인() {
        String winningNormalNumbers = "1, 2, 3, 4, 5, 6";

        winningNumbers.generateWinningNormalNumbers(winningNormalNumbers);

        List<Integer> expected = List.of(1,2,3,4,5,6);

        WinningNormalNumbers winningNormalNumber = winningNumbers.getWinningNormalNumbers();
        List<WinningNumber> winningNumbersList = winningNormalNumber.getWinningNumbers();
        for(int i = 0; i<winningNumbersList.size(); i++) {
            WinningNumber winningNumber = winningNumbersList.get(i);
            assertThat(winningNumber.getNumber())
                    .isEqualTo(expected.get(i));
        }
    }

    @Test
    void 당첨번호_생성_시_중복이_있으면_예외를_던지는지_확인() {
        String inputNumbers = "1, 2, 3, 2, 5, 6";
        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    void 보너스_숫자_잘_생성되는지_확인() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        String inputNumber = "7";

        Integer expected = 7;

        winningNumbers.generateWinningNormalNumbers(inputNumbers);
        winningNumbers.generateBonusNumber(inputNumber);

        BonusNumber bonusNumber = winningNumbers.getBonusNumber();
        assertThat(bonusNumber.getBonusNumber().getNumber())
                .isEqualTo(expected);
    }

    @Test
    void 보너스_숫자가_당첨번호와_중복되면_예외_던지는지_확인() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        String inputNumber = "3";

        winningNumbers.generateWinningNormalNumbers(inputNumbers);
        assertThatThrownBy(() -> winningNumbers.generateBonusNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATED.getMessage());
    }

    @Test
    void 당첨_숫자_개수가_6개_초과인_경우_예외를_던지는지_확인() {
        String inputNumbers = "1, 2, 3, 4, 5, 6, 7";

        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_COUNT_MUST_BE_SIX.getMessage());

    }

    @Test
    void 당첨_숫자_개수가_6개_미만인_경우_예외를_던지는지_확인() {
        String inputNumbers = "1, 2, 3, 4, 5";

        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_COUNT_MUST_BE_SIX.getMessage());

    }


}
