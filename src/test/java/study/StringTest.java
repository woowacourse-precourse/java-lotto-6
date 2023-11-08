package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("구분자로 split했을 때 잘 분리되지 않으면 예외가 발생한다.")
    @Test
    void splitByComma() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @DisplayName("구분자가 없는 경우, split했을 때 input과 동일한 결과가 반환되지 않으면 예외가 발생한다.")
    @Test
    void splitByCommaWithNoCommaInput() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring을 이용하여 ()이 제거되지 않으면 예외가 발생한다.")
    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt을 이용하여 특정 위치의 문자를 가져오지 못하면 예외가 발생한다.")
    @Test
    void charAt() {
        String input = "abc";

        char result = input.charAt(0);
        assertThat(result).isEqualTo('a');

        result = input.charAt(1);
        assertThat(result).isEqualTo('b');

        result = input.charAt(2);
        assertThat(result).isEqualTo('c');
    }

    @DisplayName("charAt을 이용할 때 범위를 벗어난 위치에 접근하면 예외가 발생한다.")
    @Test
    void charAtWithIndexOutOfBoundException() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
    }
}