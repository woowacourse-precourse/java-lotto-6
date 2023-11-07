package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringTest {

    @Test
    void split으로_문자열이_분리된다() {
        String s = "1,2";
        String[] result = s.split(",");

        // try
        assertEquals("1", result[0]);
        assertEquals("2", result[1]);

        // hint
        assertThat(result).contains("1", "2");
    }

    @Test
    void 콤마가_없는_문자열을_split한다() {
        String s = "1";
        String[] result = s.split(",");

        // try
        assertEquals("1", result[0]);
        assertEquals(1, result.length);

       // hint
       assertThat(result).containsExactly("1");
    }

    @Test
    void substring_메소드를_사용한다() {
        String s = "(1,2)";

        String result = s.substring(1, s.length() - 1);

        assertEquals("1,2", result);
    }

    @Test
    void charAt_메소드로_문자를_가져온다() {
        String s = "abc";

        assertEquals('a', s.charAt(0));
        assertEquals('b', s.charAt(1));
        assertEquals('c', s.charAt(2));
    }

    @Test
    void charAt의_인덱스_예외를_확인한다() {
        String s = "abc";

        // try
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.charAt(-1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.charAt(s.length()));

        // hint
        assertThatThrownBy(() -> s.charAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> s.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
