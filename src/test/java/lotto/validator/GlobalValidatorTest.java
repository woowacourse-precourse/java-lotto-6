package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.validator.GlobalValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class GlobalValidatorTest {

    @Test
    @DisplayName("구입 금액 숫자인지 테스트")
    void purchaseAmountDigitTest() {
        //given
        String purchaseAmount = "12300aa";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchaseAmount(purchaseAmount));
    }

    @Test
    @DisplayName("구입 금액 1000원 단위인지 테스트")
    void purchaseAmountDividedByThousandTest() {
        //given
        String purchaseAmount = "12001";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchaseAmount(purchaseAmount));
    }

    @Test
    @DisplayName("당첨 번호 숫자인지 테스트")
    void winningNumberDigitTest() {
        //given
        List<String> winningNumber = List.of("1,2,3,4,a,6");

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(winningNumber));
    }

    @Test
    @DisplayName("당첨 번호 중복인지 테스트")
    void winningNumberDuplicateTest() {
        //given
        List<String> winningNumber = List.of("1,2,3,4,6,6");

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validateWinningNumber(winningNumber));
    }

    @Test
    @DisplayName("보너스 번호 숫자인지 테스트")
    void bonusNumberDigitTest() {
        //given
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNumber = "a";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validateBonusNumber(winningNumber, bonusNumber));
    }
}