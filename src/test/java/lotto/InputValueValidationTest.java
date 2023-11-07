package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.InputValueValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValueValidationTest {

    @DisplayName("구입 금액이 숫자로만 구성되지 않으면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountWithOutDigit() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        String purchaseAmount = "1000a";
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
    }
    @DisplayName("구입 금액이 1,000원 이하면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountByUnderAmount() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        String purchaseAmount = "999";
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }
    @DisplayName("구입 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void inputPurchaseAmountByNotUnitOf1000() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        String purchaseAmount = "1001";
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
    }

    @DisplayName("당첨 번호가 숫자가 아니거나 쉼표(,)로 공백없이 구분되지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1, 2, 3, 4, 5, 6", "1.2#3$4%5^6"})
    void inputPrizeNumberWithOutDigitAndComma(String prizeNumber) {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePrizeNumber(prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 공백 없이 구분됩니다.");
    }

    @DisplayName("당첨 번호의 각 번호가 45를 초과하면 예외가 발생한다.")
    @Test
    void inputPrizeNumberExceeded() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        String prizeNumber = "1,2,3,4,5,99";
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePrizeNumber(prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다.");
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void inputPrizeNumberDuplicated() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        String prizeNumber = "1,2,3,4,5,5";
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePrizeNumber(prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되면 안됩니다.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2,3", "4,5,6", "7,8,9,10", "11,12,13,14,15", "16,17,18,19,20,21,22"})
    void inputPrizeNumberNotCorrectSize(String prizeNumber) {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // then
        assertThatThrownBy(() -> inputValueValidation.validatePrizeNumber(prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다.");
    }


    @DisplayName("보너스 번호가 숫자로만 구성되지 않으면 예외가 발생한다.")
    @Test
    void inputBonusNumberWithOutDigit() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "a";
        // then
        assertThatThrownBy(() -> inputValueValidation.validateBonusNumber(prizeNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자로만 구성됩니다.");
    }
    @DisplayName("보너스 번호가 45를 초과하면 예외가 발생한다.")
    @Test
    void inputBonusNumberExceeded() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "99";
        // then
        assertThatThrownBy(() -> inputValueValidation.validateBonusNumber(prizeNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 45 이하의 숫자로 구성됩니다.");
    }
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void inputBonusNumberIncludedInPrizeNumber() {
        // given
        InputValueValidation inputValueValidation = new InputValueValidation();
        // when
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "1";
        // then
        assertThatThrownBy(() -> inputValueValidation.validateBonusNumber(prizeNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
    }
}
