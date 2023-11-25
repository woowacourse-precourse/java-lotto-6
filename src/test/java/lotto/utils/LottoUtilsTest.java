package lotto.utils;

import lotto.constant.StringConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilsTest {

    @Test
    void convertStringToListTest() {
        String input = "1,2";
        List<String> result = LottoUtils.splitStringToList(StringConstant.COMMA, input);
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitStringWithDelimiterTest() {
        String input = "1,2";
        String[] result = LottoUtils.splitStringByDelimiter(StringConstant.COMMA, input);

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1233"})
    @DisplayName("문자열을 숫자로 변환하는지 테스트")
    void convertStringToIntegerTest(String input) {
        assertThat(LottoUtils.convertStringToInteger(input)).isInstanceOf(Integer.class);
    }

}