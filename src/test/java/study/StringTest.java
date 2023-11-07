package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 요구사항1() {
        String str = "1,2";
        String[] result = str.split(",");
        Assertions.assertThat(result).contains("1", "2");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 요구사항2() {
        String str = "(1,2)";
        String result = str.substring(1,4);
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt()메서드에서 indexOutOfRangeException 확인")
    @Test
    void 요구사항3() {
        String str = "abc";
        Assertions.assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
