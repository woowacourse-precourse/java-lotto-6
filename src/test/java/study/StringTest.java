package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String.split(): 구분자가 포함되어 있는 경우")
    void givenWithComma_whenSplitByComma_thenReturnCorrectValue() {
        String oneAndTwo = "1,2";

        String[] result = oneAndTwo.split(",");

        assertThat(result).contains("1", Index.atIndex(0));
        assertThat(result).contains("2", Assertions.atIndex(1));
        assertThat(result).contains("1", "2");
        assertThat(result).contains("2", "1");
        assertThat(result).contains("1", "2", "1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String.split(): 구분자가 없는 경우")
    void givenWithoutComma_whenSplitByComma_thenReturnCorrectValue() {
        String one = "1";

        String[] result = one.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("1", Index.atIndex(0));
        assertThat(result).containsExactly("1");
        assertThat(result.length).isOne();
    }

    @Test
    @DisplayName("String.substring(): 블록 제거")
    void givenWithBlock_whenSubstring_thenRemoveBlock() {
        String numbersWithBlock = "(1,2)";

        String result = numbersWithBlock.substring(1, 4);

        assertThat(result).doesNotStartWith("(")
                .doesNotEndWith(")");
        assertThat(result).startsWith("1")
                .endsWith("2");
        assertThat(result).isEqualTo("1,2");
        assertEquals("1,2", result);
    }

    @Test
    @DisplayName("String.charAt(): 특정 위치 문자 가져오기")
    void givenABC_whenCharAt_thenReturnCorrectValue() {
        String abc = "abc";

        char firstCharacter = abc.charAt(0);
        char secondCharacter = abc.charAt(1);
        char thirdCharacter = abc.charAt(2);

        assertEquals('a', firstCharacter);
        assertEquals('b', secondCharacter);
        assertEquals('c', thirdCharacter);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    abc.charAt(3);
                }).withMessageContaining("String index out of range", "3")
                .withNoCause();
    }

}
