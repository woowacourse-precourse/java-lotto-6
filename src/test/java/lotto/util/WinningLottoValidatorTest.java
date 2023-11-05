package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.InvalidLottoNumberFormatException;
import lotto.exception.InvalidLottoSplitterCountException;
import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {

    private static final String SPLITTER_COUNT_INVALID = "1,2,3,4,5,6,";
    private static final String EMPTY_NUMBER = ",1,2,3,4,5";
    private static final String NON_NUMERIC_VALUE = "a,2,3,4,5,6";
    private static final String CONTAINS_WHITESPACE = "1, 2, 3, 4,5,6";

    @Test
    void 구분자_개수_올바르지_않을_경우_예외_발생() {
        assertThrows(InvalidLottoSplitterCountException.class,
                () -> WinningLottoValidator.validate(SPLITTER_COUNT_INVALID));
    }

    @Test
    void 빈_요소_포함될_경우_예외_발생() {
        assertThrows(InvalidLottoNumberFormatException.class,
                () -> WinningLottoValidator.validate(EMPTY_NUMBER));
    }

    @Test
    void 정수가_아닌_요소_포함될_경우_예외_발생() {
        assertThrows(InvalidLottoNumberFormatException.class,
                () -> WinningLottoValidator.validate(NON_NUMERIC_VALUE));
    }

    @Test
    void 요소에_공백_포함될_경우_예외_발생() {
        assertThrows(InvalidLottoNumberFormatException.class,
                () -> WinningLottoValidator.validate(CONTAINS_WHITESPACE));
    }
}