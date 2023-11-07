package lotto.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("1,2를 ,로 split했을 때 정상적으로 분리하는지")
    @Test
    void splitTest() {
        // given
        String input = "1,2";
        String[] expectedSplitInput = {"1", "2"};

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).contains(expectedSplitInput);
    }

    @DisplayName("1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    @Test
    void splitTestOne() {
        // given
        String input = "1";
        String[] expectedSplitInput = {"1"};

        // when
        String[] splitInput = input.split(",");

        // then
        assertThat(splitInput).containsExactly(expectedSplitInput);
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환하는지")
    @Test
    void substringTest() {
        // given
        String input = "(1,2)";
        String expectedSubstringInput = "1,2";

        // when
        String substringInput = input.substring(1, input.length()-1);

        // then
        assertThat(substringInput).isEqualTo(expectedSubstringInput);
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지")
    @Test
    void charAtAbcTest() {
        // given
        String input = "abc";
        char[] expectedChars = {'a', 'b', 'c'};

        // when & then
        for (int i = 0; i < input.length(); i++) {
            assertThat(input.charAt(i)).isEqualTo(expectedChars[i]);
        }
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지")
    @Test
    void charAtIndexOutTest() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> {
            for (int i = 0; i<input.length()+1; i++) {
                input.charAt(i);
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    for (int i = 0; i<input.length()+1; i++) {
                        input.charAt(i);
                    }
                }).withMessageMatching("String index out of range: \\d+");
    }
}
