package lotto.domain;

import lotto.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @Test
    void 중복_예외처리() {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});

        errorMessageTest(() -> {
            BonusNumber.createBonusNumber(new WinningNumber(6), winningNumbers);
        }, ErrorMessage.DUPLICATED_BONUS_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스_번호_확인_테스트_false(int number) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        WinningNumber initialBonusNumber = new WinningNumber(7);

        BonusNumber bonusNumber = BonusNumber.createBonusNumber(initialBonusNumber, winningNumbers);

        Assertions.assertThat(bonusNumber.isBonusNumber(number))
                .isFalse();
    }

    @Test
    void 보너스_번호_확인_테스트_ture() {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        WinningNumber initialBonusNumber = new WinningNumber(7);

        BonusNumber bonusNumber = BonusNumber.createBonusNumber(initialBonusNumber, winningNumbers);

        Assertions.assertThat(bonusNumber.isBonusNumber(7))
                .isTrue();
    }

    private void errorMessageTest(ThrowableAssert.ThrowingCallable executable, ErrorMessage errorMessage) {
        org.assertj.core.api.Assertions.assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getErrorMessage());
    }
}
