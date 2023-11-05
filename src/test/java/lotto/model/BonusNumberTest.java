package lotto.model;

import static lotto.constant.ValidateMessage.BONUS_NUMBER_IS_BETWEEN_1_TO_45;
import static lotto.constant.ValidateMessage.BONUS_NUMBER_IS_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호는 1 ~ 45 사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void isNotBetween1And45() {
        //given
        int bonusNumber = 100;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(createWinnerNumber(), bonusNumber));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_IS_BETWEEN_1_TO_45.message));
    }

    @DisplayName("보너스 번호는 1 ~ 45 사이 숫자이다.")
    @Test
    void isBetween1And45() {
        //given
        BonusNumber bonusNumber = new BonusNumber(createWinnerNumber(), 45);

        //then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(45);
    }

    @DisplayName("보너스 번호는 당첨 숫자와 중복되면 안된다.")
    @Test
    void createBonusNumberDuplicateWithWinnerNumber() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(createWinnerNumber(), 6));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_IS_DUPLICATE.message));
    }


    private WinnerNumber createWinnerNumber() {
        return new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
    }
}