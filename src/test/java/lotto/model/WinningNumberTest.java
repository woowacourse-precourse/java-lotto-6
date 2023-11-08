package lotto.model;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;
import static lotto.util.Constants.NUMBERS_SIZE;
import static lotto.util.ExceptionMessage.COMMON_INVALID_RANGE;
import static lotto.util.ExceptionMessage.COMMON_INVALID_TYPE;
import static lotto.util.ExceptionMessage.WINNING_NUMBER_INVALID_DELIMITER;
import static lotto.util.ExceptionMessage.WINNING_NUMBER_INVALID_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 당첨번호는_콤마를_구분하여_적는다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new WinningNumber("1 2 3 4 5 6"));
        assertEquals(e.getMessage(), WINNING_NUMBER_INVALID_DELIMITER.getMessage());
    }

    @Test
    void 당첨번호는_숫자들만_적는다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new WinningNumber("asdf,asdf,sdf,sdf,sd,as"));
        assertEquals(e.getMessage(), COMMON_INVALID_TYPE.getMessage());
    }

    @Test
    void 당첨번호는_서로_다른_6개의_숫자로_적는다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new WinningNumber("1,2,3,3,4,5"));
        assertEquals(e.getMessage(), String.format(WINNING_NUMBER_INVALID_SIZE.getMessage(), NUMBERS_SIZE));
    }

    @Test
    void 당첨번호는_1과_45사이의_숫자로_적는다() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new WinningNumber("1,2,49,284,4,5"));
        assertEquals(e.getMessage(), String.format(COMMON_INVALID_RANGE.getMessage(), MIN_NUMBER, MAX_NUMBER));
    }


}