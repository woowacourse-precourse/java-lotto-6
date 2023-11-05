package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private final Lotto lotto = Lotto.create("1,2,3,4,5,6");

    @DisplayName("보너스 번호가 1개가 아닌 경우 예외 발생 테스트")
    @Test
    void isNotOntBonusNumber() {

        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers(lotto, "10,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_IS_NOT_ONE.get());
    }

    @DisplayName("보너스 번호 입력 널값인 경우 예외 발생 테스트")
    @Test
    void validateBonusNumber() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers(lotto, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_NULL.get());
    }

    @DisplayName("보너스 번호에 공백 포함된 경우 예외 발생 테스트")
    @Test
    void validateBonusNumber2() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers(lotto, " 10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_CONTAINS_BLANK.get());
    }

    @DisplayName("당첨 로또 번호와 보너스 번호와 중복인 경우 예외 발생 테스트")
    @Test
    void createWinningNumbers() {
        assertThatThrownBy(() -> WinningNumbers.createWinningNumbers(lotto, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_DUPLICATE.get());
    }


}