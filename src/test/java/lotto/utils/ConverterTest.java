package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ConverterTest {

    @Test
    @DisplayName("문자열에서 숫자 리스트로 변환할 수 있다.")
    void toIntegerList() {
        String source = "1,2,3,4,5,6";
        List<Integer> result = Converter.toIntegerList(source);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}