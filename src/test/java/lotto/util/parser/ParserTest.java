package lotto.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @DisplayName(",가 포함된 문자열을 입력받으면 ,를 기준으로 List&lt;Integer&gt;로 파싱한다.")
    @Test
    void parseCommaStringToIntList() {
        String input = "1,2,3,4,5,6";
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Parser.parseCommaStringToIntList(input)).isEqualTo(integerList);
    }

    @DisplayName(",가 없는 문자열을 입력받으면 IllegalArgumentException이 발생한다.")
    @Test
    void parseCommaStringToIntList_Without_Comma_Exception() {
        String input = "1 2 3 4 5 6";
        assertThatThrownBy(() -> Parser.parseCommaStringToIntList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String을 int로 파싱한다.")
    @Test
    void parseStringToInt() {
        String input = "1";
        assertThat(Parser.parseStringToInt(input)).isEqualTo(1);
    }

    @DisplayName("String을 int로 파싱 시 음수를 입력받으면 IllegalArgumentException이 발생한다.")
    @Test
    void parseStringToInt_NegativeNumber_Exception() {
        String input = "-1";
        assertThatThrownBy(() -> Parser.parseStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String을 int로 파싱 시 숫자가 아닌 문자를 입력받으면 IllegalArgumentException이 발생한다.")
    @Test
    void parseStringToInt_NotNumber_Exception() {
        String input = "a";
        assertThatThrownBy(() -> Parser.parseStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
