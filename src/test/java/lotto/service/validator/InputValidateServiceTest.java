package lotto.service.validator;

import lotto.util.Constant;
import lotto.view.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputValidateServiceTest {

    private List<Integer> validNumbers;
    private List<Integer> winningNumbers;

    @BeforeEach
    public void setUp() {
        validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
    }

    @Test
    @DisplayName("유효한 구매 금액 검증")
    public void testValidPurchaseAmount() {
        int validPurchaseAmount = Constant.LOTTO_PRICE * 5;
        Assertions.assertThatCode(() -> InputValidateService.validatePurchaseAmount(validPurchaseAmount))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구매 금액이 0 이하일 때 검증")
    public void testInvalidPurchaseAmount() {
        int invalidPurchaseAmount = 0;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validatePurchaseAmount(invalidPurchaseAmount))
                .withMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("로또 가격 1000 단위가 아닌 구매 금액 검증")
    public void testNotMultipleOfLottoPrice() {
        int invalidPurchaseAmount = Constant.LOTTO_PRICE - 1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validatePurchaseAmount(invalidPurchaseAmount))
                .withMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("유효한 로또 번호 검증")
    public void testValidNumbersOfLottoNumbers() {
        Assertions.assertThatCode(() -> InputValidateService.validateNumbers(validNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호 개수 불일치 검증")
    public void testInvalidNumbersOfLottoNumbers() {
        List<Integer> invalidNumbersCount = Arrays.asList(1, 2, 3);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validateNumbers(invalidNumbersCount))
                .withMessage(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT);
    }

    @Test
    @DisplayName("로또 번호 중복 검증")
    public void testInvalidDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 5);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validateNumbers(duplicateNumbers))
                .withMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("로또 번호 범위 초과 검증")
    public void testValidateNumbersOutOfRange() {
        List<Integer> numbersOutOfRange = Arrays.asList(-1, 0, 1, 2, 3, 4);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validateNumbers(numbersOutOfRange))
                .withMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("유효한 보너스 번호 검증")
    public void testValid_BonusNumber() {
        int validBonusNumber = 7;
        Assertions.assertThatCode(() -> InputValidateService.validateBonusNumber(validBonusNumber, winningNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호 범위 초과 검증")
    public void testInvalid_OutOfRangeBonusNumber() {
        int bonusNumberOutOfRange = -1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validateBonusNumber(bonusNumberOutOfRange, winningNumbers))
                .withMessage(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 검증")
    public void testInvalidDuplicateWithWinningNumbers() {
        int duplicateBonusNumber = 5; // Assuming this is a number in the winningNumbers
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidateService.validateBonusNumber(duplicateBonusNumber, winningNumbers))
                .withMessage(ErrorMessage.DUPLICATE_BONUS_NUMBERS);
    }
}