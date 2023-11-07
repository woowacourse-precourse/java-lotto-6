package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    void stringToIntList_숫자가_아닌_문자일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.stringToIntList("qwer,12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntList_문자열이_없을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.stringToIntList(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntList_문자열을_Integer_List로_변환한다() {
        assertEquals(Parser.stringToIntList("1,2,3,4,5,6"), List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void stringToInt_숫자가_아닌_문자일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.stringToInt("qwer"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToInt_문자열이_없을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.stringToInt(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntList_문자열을_int로_변환한다() {
        assertEquals(Parser.stringToInt("10"), 10);
    }
}