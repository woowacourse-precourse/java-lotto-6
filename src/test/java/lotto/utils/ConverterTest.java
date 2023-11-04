package lotto.utils;

import lotto.utils.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConverterTest {

    @Test
    void stringToInt_숫자인_문자열을_정수로_변환() {
        String input = "123";
        int result = Converter.stringToInt(input);

        Assertions.assertThat(result).isEqualTo(123);
    }
    @Test
    void stringToInt_숫자가_아닌_문자열을_정수로_변환_예외_발생() {
        String input = "notNumber";

        assertThrows(IllegalArgumentException.class, () -> Converter.stringToInt(input));
    }

    @Test
    void stringToIntList_쉼표로_구분된_숫자들의_문자열을_정수_리스트로_변환() {
        String inputString = "1,2,3,4,5,6";
        String delimiter = ",";

        List<Integer> result = List.of(1,2,3,4,5,6);
        Assertions.assertThat(result).isEqualTo(Converter.stringToIntList(inputString, delimiter));
    }

    @Test
    void stringToIntList_구분자를_잘못_입력한_경우_예외_발생() {
        String inputString = "1,2,3,4,5,6";
        String delimiter = "-";

        List<Integer> result = List.of(1,2,3,4,5,6);
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToIntList(inputString, delimiter));
    }
}
