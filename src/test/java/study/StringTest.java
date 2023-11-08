package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("결과 값인 배열과 예상하는 값이 완전히 같이 않으면 예외가 발생한다.")
    @Test
    void 입력값_split_2개() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
//        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("결과 값인 배열에 예상하는 값이 포함되지 않으면 예외가 발생한다.")
    @Test
    void 입력값_split_1개() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1", "2");
    }

    @DisplayName("괄호를 제외한 1,2 문자열이 존재하지 않으면 예외 발생한다.")
    @Test
    void 입력값_substring() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치 문자가 반환 되지 않으면 예외가 발생한다.")
    @Test
    void 특정_위치_문자() {
        String input = "12345";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('2');
    }
    @DisplayName("문자열 범위를 벗어난 문자를 가져오게 하여 예외가 발생한다.")
    @Test
    void 문자열_범위_벗어난_경우_메시지가_동일한지_확인() {
        String input = "12345";
        assertThatThrownBy(() -> {
            throw new StringIndexOutOfBoundsException("Error");
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Error");
    }

    @DisplayName("문자열 범위를 벗어났을 때 발생하는 예외와 예상하는 예와가 동일하지 않을 때 예외가 발생한다.")
    @Test
    void 문자열_범위_확인2() {
        String input = "12345";
        assertThatThrownBy(() -> {
            throw new StringIndexOutOfBoundsException("Error");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @DisplayName("예상하는 예외와 문자열 범위를 벗어 났을 때 나오는 예외가 같은지, 메시지가 완전히 같은지 확인한다.")
    @Test
    void 문자열_범위_확인3() {
        String input = "1234";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(5))
                .withMessageMatching("String index out of range: 5");

    }
}
