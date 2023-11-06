package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @Test
    @DisplayName("문자열을 숫자로 변환하는지 확인한다.")
    void convertStringToInt() {
        assertThat(Converter.stringToInt("8000")).isEqualTo(8000);
    }

    @Test
    @DisplayName("문자열을 List<Integer>로 변환하는지 확인한다.")
    void convertStringToListInteger() {
        assertThat(Converter.stringToListInteger("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
