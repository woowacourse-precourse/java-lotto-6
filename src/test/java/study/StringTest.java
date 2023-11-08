package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("\"1,2\"을 ,로 split했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split_ShouldReturn1And2() {
        // given
        String given = "1,2";
        String regex = ",";
        String[] expected = { "1", "2" };
        // when
        String[] actual = given.split(regex);
        // then
        assertThat(actual).containsExactly(expected);
    }

    @DisplayName("\"1\"을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split_ShouldReturnOnly1() {
        // given
        String given = "1";
        String regex = ",";
        String[] expected = { "1" };
        // when
        String[] actual = given.split(regex);
        // then
        assertThat(actual).containsExactly(expected);
    }

    @DisplayName("\"(1,2)\"값이 주어졌을 때 subString() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인")
    @Test
    void subString_ShouldReturn1And2() {
        // given
        String given = "(1,2)";
        String expected = "1,2";
        // when
        String actual = given.substring(1, given.length() - 1);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("\"abc\"값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    @Test
    void charAt_ShouldReturnB() {
        // given
        String given = "abc";
        int index = 1;
        char expected = 'b';
        // when
        char actual = given.charAt(index);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("\"abc\"값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생하는지 확인")
    @Test
    void charAt_ShouldThrowIndexOutOfBoundsException() {
        // given
        String given = "abc";
        int index = 3;
        // when
        // then
        assertThatThrownBy(() -> {
            given.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
        // or then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    given.charAt(index);
                }).withMessageMatching("String index out of range: " + index);
    }
}
