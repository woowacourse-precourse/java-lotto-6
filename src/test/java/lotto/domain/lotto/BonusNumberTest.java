package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.domain.bonusnumber.BonusNumberDuplicateException;
import lotto.exception.domain.bonusnumber.BonusNumberFormatException;
import lotto.exception.domain.lotto.LottoNumRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 숫자 검증 테스트")
class BonusNumberTest {

    WinningNumbers winningNumbers;

    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "45"})
    @DisplayName("1~45 범위의 숫자를 입력했을 때 보너스 넘버가 정상적으로 생성된다.")
    void testValidBonusNumber(String inputNum) {
        winningNumbers = WinningNumbers.create("2, 3, 5, 7, 8, 9");
        BonusNumber bonusNumber = BonusNumber.create(inputNum, winningNumbers);

        assertEquals(Integer.parseInt(inputNum), bonusNumber.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "invalidNum", "1,2"})
    @DisplayName("숫자가 아닌 경우를 입력했을 때 예외 발생")
    void testInValidFormat(String invalidInput) {
        winningNumbers = WinningNumbers.create("1, 3, 5, 7, 8, 9");

        assertThrows(BonusNumberFormatException.class, () -> {
            BonusNumber.create(invalidInput, winningNumbers);
        });
    }

    @Test
    @DisplayName("숫자가 1~45 사이의 수가 아닌 경우 예외 발생")
    void testOutOfRange() {
        winningNumbers = WinningNumbers.create("1, 3, 5, 7, 8, 9");

        assertThrows(LottoNumRangeException.class, () -> {
            BonusNumber.create("46", winningNumbers);
        });
    }

    @Test
    @DisplayName("보너스 숫자에 당첨 번호와 중복된 숫자가 있다면 예외 발생")
    void testDuplicateNum() {
        winningNumbers = WinningNumbers.create("1, 3, 5, 7, 8, 9");

        assertThrows(BonusNumberDuplicateException.class, () -> {
           BonusNumber.create("9", winningNumbers);
        });
    }
}