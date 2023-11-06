package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        List<Integer> validWinningNumbers = new ArrayList<>();
        int number = LottoConstants.LOTTO_START_NUMBER.getConstant();
        for (int i = 0; i < LottoConstants.LOTTO_PER_NUMBERS.getConstant(); i++) {
            validWinningNumbers.add(number);
            number++;
        }
        LottoInputValidator.WinningNumbersIsValid(validWinningNumbers);
    }

    @DisplayName("입력한 당첨 번호가 6개가 아닌 경우 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidWinningNumbersByLottoPerNumbers() {
        List<Integer> invalidWinningNumbers = new ArrayList<>();
        int number = LottoConstants.LOTTO_START_NUMBER.getConstant();
        for (int i = 0; i < LottoConstants.LOTTO_PER_NUMBERS.getConstant() + 1; i++) {
            invalidWinningNumbers.add(number);
            number++;
        }
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoInputValidator.WinningNumbersIsValid(invalidWinningNumbers));
    }

    @DisplayName("입력한 당첨 번호가 지정된 범위에 없는 번호일 경우 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidWinningNumbersByLottoNumbers() {
        List<Integer> invalidWinningNumbers = new ArrayList<>();
        int number = LottoConstants.LOTTO_START_NUMBER.getConstant();
        for (int i = 0; i < LottoConstants.LOTTO_PER_NUMBERS.getConstant() + 1; i++) {
            invalidWinningNumbers.add(number);
            number--;
        }
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoInputValidator.WinningNumbersIsValid(invalidWinningNumbers)
        );
    }
}
