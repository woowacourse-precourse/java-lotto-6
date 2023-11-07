package lotto.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    @DisplayName("정렬 번호 컨버터: 정렬되지 않은 List<Integer>를 정렬해서 반환")
    void givenUnsortedNumbers_whenConvert_thenReturnSortedNumbers() {
        // given
        List<Integer> unsortedNumbers = List.of(6, 5, 4, 3, 2, 1);

        // when & then
        SortNumbersConverter sortNumbersConverter = new SortNumbersConverter();
        assertThat(sortNumbersConverter.convert(unsortedNumbers)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}
