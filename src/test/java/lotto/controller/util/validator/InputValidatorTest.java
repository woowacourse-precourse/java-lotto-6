package lotto.controller.util.validator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("[정상] 금액 입력")
    public void validMoney() {
        int money = 8000;

        Assertions.assertThatCode(() -> inputValidator.validateMoney(money))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[오류] 1000원 단위가 아닌 금액 입력")
    public void validMoneyFailUnit() {
        int money = 8010;

        Assertions.assertThatThrownBy(() -> inputValidator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 1000원 보다 적은 금액")
    public void validMoneyFailMinMoney() {
        int money = 600;

        Assertions.assertThatThrownBy(() -> inputValidator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[정상] 당첨 번호 입력")
    public void validWinningNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatCode(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[오류] 당첨 번호가 6자리보다 적음")
    public void validWinningNumberFailSizeLess() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        Assertions.assertThatThrownBy(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 당첨 번호가 6자리보다 큼")
    public void validWinningNumberFailSizeGreater() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Assertions.assertThatThrownBy(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 당첨 번호가 중복됨")
    public void validWinningNumberFailDuplicated() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 6);

        Assertions.assertThatThrownBy(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 당첨 번호가 범위를 벗어남")
    public void validWinningNumberFailOutOfRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 46);

        Assertions.assertThatThrownBy(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 당첨 번호가 범위를 벗어남2")
    public void validWinningNumberFailOutOfRange2() {
        List<Integer> winningNumbers = List.of(0, 2, 3, 4, 4, 46);

        Assertions.assertThatThrownBy(() -> inputValidator.validateDrawNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[정상] 보너스 번호 입력")
    public void validBonusNumber() {
        int bonusNumber = 10;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 6);

        inputValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    @Test
    @DisplayName("[오류] 보너스 번호가 범위를 벗어남")
    public void validBonusNumberFailOutOfRange() {
        int bonusNumber = 46;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 6);

        Assertions.assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[오류] 보너스 번호가 중복됨")
    public void validBonusNumberFailDuplicated() {
        int bonusNumber = 6;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 6);

        Assertions.assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}