package lotto;

import static org.assertj.core.api.Assertions.assertThat;

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
}