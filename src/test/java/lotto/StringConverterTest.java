package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {
    @DisplayName("문자열 리스트를 정수형 리스트로 변환한다.")
    @Test
    void convertToIntegerList() {
        //given
        StringConverter stringConverter = new StringConverter();
        String numbers = "1,2,3,4,5,6";

        //when
        List<Integer> convertedNumbers = stringConverter.convertToIntegerList(numbers);

        //then
        assertThat(convertedNumbers).hasSize(6)
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("문자열을 정수로 변환한다.")
    @Test
    void convertToInteger(){
        //given
        StringConverter stringConverter = new StringConverter();
        String number = "100";

        //when
        int convertNumber = stringConverter.covertToInteger(number);

        //then
        assertThat(convertNumber).isInstanceOf(Integer.class)
                .isEqualTo(100);
    }

    @DisplayName("문자열 리스트에 숫자가 아닌 문자열이 들어있으면 반환할때 예외가 발생한다.")
    @Test
    void convertToIntegerListWithNoDigit() {
        //given
        StringConverter stringConverter = new StringConverter();
        String numbers = "1,2,3,4,5,a";

        //when //then
        assertThatThrownBy(() -> stringConverter.convertToIntegerList(numbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("문자가 정수가 아닌 경우 반환할때 예외가 발생한다.")
    @Test
    void converToIntegerWithNoDigit() {
        //given
        StringConverter stringConverter = new StringConverter();
        String number = "100a";

        //when //then
        assertThatThrownBy(() -> stringConverter.covertToInteger(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}