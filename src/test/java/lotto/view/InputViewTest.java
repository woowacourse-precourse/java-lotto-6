package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

class InputViewTest {


    @Test
    @DisplayName("구입 금액을 유효하게 입력받는다")
    void getPurchaseAmount() {
        // 유효한 금액 입력
        String validAmount = "3000";
        assertEquals(3000, PurchaseAmountValidator.parseAndValidatePurchaseAmount(validAmount));

        // 유효하지 않은 금액 입력 (1000원 미만)
        String invalidAmount1 = "500";
        IllegalArgumentException invalidAmountException1 = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(invalidAmount1));
        assertEquals("[ERROR] 최소 구입 금액은 1000원입니다.", invalidAmountException1.getMessage());

        // 유효하지 않은 금액 입력 (1000원 단위가 아님)
        String invalidAmount2 = "2500";
        IllegalArgumentException invalidAmountException2 = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(invalidAmount2));
        assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어져야 합니다.", invalidAmountException2.getMessage());

        // 유효하지 않은 입력 (문자열)
        String invalidAmount3 = "abc";
        IllegalArgumentException invalidAmountException3 = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(invalidAmount3));
        assertEquals("[ERROR] 올바른 금액을 입력해 주세요.", invalidAmountException3.getMessage());
    }

    @Test
    @DisplayName("당첨 번호를 유효하게 입력받는다")
    void getWinningNumbers() {
        // 유효한 당첨 번호 입력
        String validNumbers = "6,15,20,27,37,42";
        assertEquals(6, WinningNumbersValidator.validateWinningNumbers(validNumbers).size());

        // 유효하지 않은 당첨 번호 입력 (개수 부족)
        String invalidNumbers1 = "1,2,3,4,5";
        IllegalArgumentException invalidNumbersException1 = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidNumbers1));
        assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", invalidNumbersException1.getMessage());

        // 유효하지 않은 당첨 번호 입력 (범위 초과)
        String invalidNumbers2 = "1,2,3,4,5,46";
        IllegalArgumentException invalidNumbersException2 = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidNumbers2));
        assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", invalidNumbersException2.getMessage());

        // 중복 당첨 번호 입력
        String invalidNumbers3 = "1,2,3,4,4,5";
        IllegalArgumentException invalidNumbersException3 = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidNumbers3));
        assertEquals("[ERROR] 중복되지 않는 숫자 6개를 입력해 주세요.", invalidNumbersException3.getMessage());
    }

    @Test
    @DisplayName("보너스 번호를 유효하게 입력받는다")
    void getBonusNumber() {
        // 유효한 보너스 번호 입력
        String validBonusNumber = "7";
        assertEquals(7, BonusNumberValidator.validateBonusNumber(validBonusNumber, Set.of(1, 2, 3, 4, 5, 6)));

        // 유효하지 않은 보너스 번호 입력 (범위 초과)
        String invalidBonusNumber1 = "46";
        IllegalArgumentException invalidBonusNumberException1 = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(invalidBonusNumber1, Set.of(1, 2, 3, 4, 5, 6)));
        assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", invalidBonusNumberException1.getMessage());

        // 유효하지 않은 보너스 번호 입력 (이미 당첨 번호로 선택된 경우)
        String invalidBonusNumber2 = "6";
        IllegalArgumentException invalidBonusNumberException2 = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(invalidBonusNumber2, Set.of(1, 2, 3, 4, 5, 6)));
        assertEquals("[ERROR] 이미 당첨 번호로 선택된 숫자입니다.", invalidBonusNumberException2.getMessage());

        // 유효하지 않은 입력 (문자열)
        String invalidBonusNumber3 = "abc";
        IllegalArgumentException invalidBonusNumberException3 = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(invalidBonusNumber3, Set.of(1, 2, 3, 4, 5, 6)));
        assertEquals("[ERROR] 숫자만 입력해 주세요.", invalidBonusNumberException3.getMessage());
    }
}
