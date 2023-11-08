package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {
    @DisplayName("구분자를 제외한 정수가 아닌 문자가 포함되어 있을 경우 예외를 발생한다.")
    @Test
    void convertNotIntegerString() {
        String str = "1, 2, 3, 4, 5, c";
        String delimiter = ",";

        assertThatThrownBy(() -> Converter.stringToIntegerList(str, delimiter))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구분자로 구분되는 문자열을 정수 List로 변환한다.")
    @Test
    void convertStringToInteger() {
        String str = "1, 2, 3, 4, 5";
        String delimiter = ",";

        List<Integer> intList = Converter.stringToIntegerList(str, delimiter);

        assertThat(intList).contains(1, 2, 3, 4, 5);
    }

    @DisplayName("마지막이 구분자로 끝나더라도 정상적으로 List로 변환된다.")
    @Test
    void convertBlankToInteger() {
        String str = "1, 2, 3, 4, 5,  ";
        String delimiter = ",";

        List<Integer> intList = Converter.stringToIntegerList(str, delimiter);
        System.out.println(intList);

        assertThat(intList).contains(1, 2, 3, 4, 5);
        assertThat(intList).hasSize(5);
    }

    @DisplayName("하나의 문자이더라도 정상적으로 List로 변환된다.")
    @Test
    void convertOneNumberOfList() {
        String str = "1  ";
        String delimiter = ",";

        List<Integer> intList = Converter.stringToIntegerList(str, delimiter);
        System.out.println(intList);

        assertThat(intList).contains(1);
        assertThat(intList).hasSize(1);
    }
}
