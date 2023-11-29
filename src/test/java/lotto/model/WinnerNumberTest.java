package lotto.model;

import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_CAN_NOT_BE_DUPLICATE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_SIZE_IS_SIX;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberTest {
    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void isDuplicate_Test() {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinnerNumber.createWinnerNumber(List.of(1, 2, 3, 4, 5, 5)));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_CAN_NOT_BE_DUPLICATE.getMessage()));
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @Test
    void isBetweenOneAndFortyFive_Test() {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinnerNumber.createWinnerNumber(List.of(-1, 0, 46, 100, 55, 60)));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE.getMessage()));
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void winnerNumber_SizeMustBeSix_Test() {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinnerNumber.createWinnerNumber(List.of(1, 2, 3, 4, 5)));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_SIZE_IS_SIX.getMessage()));
    }

    @DisplayName("당첨 번호 정상 생성 테스트")
    @Test
    void general_Create_WinnerNumber() {
        //then
        assertDoesNotThrow(() -> WinnerNumber.createWinnerNumber(List.of(1, 2, 3, 4, 5, 6)));
    }
}