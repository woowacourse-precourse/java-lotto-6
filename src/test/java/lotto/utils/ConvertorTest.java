package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertorTest {
    @DisplayName("콤마를 기준으로 문자열을 잘 나누는가?")
    @Test
    void convertor_콤마로_문자열_나누기() {
        String input = "1,2,3,4,5,6";
        List<String> inputs = List.of("1", "2", "3", "4", "5", "6");
        assertThat(Convertor.convertStringToList(input)).isEqualTo(inputs);
    }
}
