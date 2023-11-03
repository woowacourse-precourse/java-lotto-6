package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
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
        List<String> numbers = new ArrayList<>();
        numbers.addAll(List.of("1", "2", "3", "4", "5", "6"));

        //when
        List<Integer> convertNumbers = stringConverter.convertToIntegerList(numbers);

        //then
        assertThat(convertNumbers).hasSize(6)
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("문자열 리스트에 숫자가 아닌 문자열이 들어있으면 반환할때 예외가 발생한다.")
    @Test
    void convertToIntegerListWithNotDigit(){
        //given
        StringConverter stringConverter = new StringConverter();
        List<String> numbers = new ArrayList<>();
        numbers.addAll(List.of("1", "2", "3", "4", "5", "a"));

        //when //then
        assertThatThrownBy(() -> stringConverter.convertToIntegerList(numbers))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR] 번호와 금액은 정수여야 합니다.");
    }
}