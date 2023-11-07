package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("1,2를 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void testSplitNumbers() {
        String numbers = "1,2";

        assertThat(numbers.split(",")).contains("1", "2");
    }

    @DisplayName("1,를 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    void testSplitOnlyNumberAndComma() {
        String numbers = "1,";

        assertThat(numbers.split(",")).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 ()를 제거하고 1,2를 반환한다.")
    @Test
    void testSubstring() {
        String numbers = "(1,2)";
        String answer = "1,2";

        assertThat(numbers.substring(1, 4)).isEqualTo(answer);
    }

    @DisplayName("abc가 주어졌을 때 charAt() 메서드로 특정 위치의 문자를 가져온다.")
    @Test
    void testCharAt() {
        String string = "abc";

        assertThat(string.charAt(1)).isEqualTo('b');
    }

    @DisplayName("charAt() 메서드 사용 시 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void testCharAtException() {
        String string = "abc";

        org.junit.jupiter.api.Assertions.assertThrows(StringIndexOutOfBoundsException.class,
                () -> string.charAt(5));
    }
}
