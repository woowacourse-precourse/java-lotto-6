package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoInputValidatorTest {
    @DisplayName("입력한 로또 구입금액은 로또의 가격과 나누어떨어져야 한다")
    @Test
    void testValidPurchasePrice() {
        int validPurchasePrice = LottoConstants.LOTTO_PRICE.getConstant() * 5;

        LottoInputValidator.purchasePriceIsValid(validPurchasePrice);
    }

    @DisplayName("입력한 로또 구입금액이 로또의 가격과 나누어떨어지지 않는다면"
            + "IllegalArgumentException Error 가 발생한다")
    @Test
    void testInvalidPurchasePrice() {
        int invalidPurchasePrice = LottoConstants.LOTTO_PRICE.getConstant() + 1;
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoInputValidator.purchasePriceIsValid(invalidPurchasePrice));
    }

    @DisplayName("입력한 당첨 번호는 알맞은 구분자와 숫자 범위와 갯수를 만족해야한다.")
    @Test
    void testValidWinningNumbers() {
        List<Integer> validWinningNumbers;
        int number = LottoConstants.LOTTO_START_NUMBER.getConstant();
        validWinningNumbers = createWinningNumbers(number);
        LottoInputValidator.WinningNumbersIsValid(validWinningNumbers);
    }

    @DisplayName("입력한 당첨 번호가 6개가 아닌 경우 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidWinningNumbersByLottoPerNumbers() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        List<Integer> invalidWinningNumbers = createWinningNumbers(startNumber);
        invalidWinningNumbers.remove(0);
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoInputValidator.WinningNumbersIsValid(invalidWinningNumbers));
    }

    @DisplayName("입력한 당첨 번호 중 중복이 있으면 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidWinningNumbersByHasDuplicate() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        List<Integer> invalidWinningNumbers = createWinningNumbers(startNumber);
        invalidWinningNumbers.set(1, startNumber);
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoInputValidator.WinningNumbersIsValid(invalidWinningNumbers));
    }

    @DisplayName("입력한 당첨 번호가 지정된 범위에 없는 번호일 경우 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidWinningNumbersByLottoNumbers() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        List<Integer> invalidWinningNumbers = createWinningNumbers(startNumber);
        invalidWinningNumbers.set(0, startNumber - 1);
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoInputValidator.WinningNumbersIsValid(invalidWinningNumbers)
        );
    }

    @DisplayName("보너스 번호가 지정된 범위에 있고, 당첨 번호와 중복되지 않아야 한다.")
    @Test
    void testValidBonusNumber() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        LottoInputValidator.bonusNumberIsValid(
                createWinningNumbers(startNumber),
                LottoConstants.LOTTO_END_NUMBER.getConstant()
        );
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidBonusNumberByWinningNumbersContain() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        List<Integer> winningNumbers = createWinningNumbers(startNumber);
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoInputValidator.bonusNumberIsValid(winningNumbers, startNumber)
        );
    }

    @DisplayName("보너스 번호가 지정된 범위 안에 있지 않다면 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidBonusNumberByLottoNumber() {
        int startNumber = LottoConstants.LOTTO_START_NUMBER.getConstant();
        List<Integer> winningNumbers = createWinningNumbers(startNumber);
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoInputValidator.bonusNumberIsValid(
                        winningNumbers,
                        LottoConstants.LOTTO_END_NUMBER.getConstant() + 1
                )
        );
    }

    private List<Integer> createWinningNumbers(int startNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < LottoConstants.LOTTO_PER_NUMBERS.getConstant(); i++) {
            winningNumbers.add(startNumber);
            startNumber++;
        }
        return winningNumbers;
    }
}
