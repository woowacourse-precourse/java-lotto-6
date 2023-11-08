package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinningNumbersExceptionTest {

    WinningNumbersException winningNumbersException = new WinningNumbersException();

    @Test
    void 당첨_번호_6개_미만_입력 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.underLength("1"));

        assertEquals("[ERROR]숫자 6개 입력하세요.", exception.getMessage());
    }

    @Test
    void 당첨_번호_6개_초과_입력 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.exceedsLength("1,2,3,4,5,6,7"));

        assertEquals("[ERROR]입력을 초과했습니다.", exception.getMessage());
    }

    @Test
    void 당첨_번호_숫자가_아닌_경우 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.notNumeric("abcd"));

        assertEquals("[ERROR]숫자를 입력하세요.", exception.getMessage());
    }

    @Test
    void 당첨_번호_범위_벗어난_경우 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.outsideRange("1,2,3,4,5,46"));

        assertEquals("[ERROR]입력 범위를 벗어났습니다.", exception.getMessage());
    }

    @Test
    void 당첨_번호_중복_입력 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.duplicateNumber("1,1,2,2,3,4"));

        assertEquals("[ERROR]입력이 중복되었습니다.", exception.getMessage());
    }

    @Test
    void 당첨_번호_쉼표_없을_경우 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.nonComma("1 2 3 4 5 6"));

        assertEquals("[ERROR]쉼표로 구분해주세요.", exception.getMessage());
    }

    @Test
    void 쉼표_마지막에_있는_경우 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningNumbersException.lastComma("1,2,3,4,5,6,"));

        assertEquals("필요하지 않은 콤마는 지워주세요.", exception.getMessage());
    }
}
