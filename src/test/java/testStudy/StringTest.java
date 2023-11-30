package testStudy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1,2를 split했을 떄 분리 테스트")
    public void splitNumberTest() {
        //given
        String inputNumber = "1,2";
        //when
        String[] inputNumberSplit = inputNumber.split(",");
        //then
        assertThat(inputNumberSplit).containsExactly("1", "2");

        assertThat(inputNumberSplit).contains("1");
        assertThat(inputNumberSplit).contains("2");
    }

    @Test
    @DisplayName("1,를 split했을 떄 분리 테스트")
    public void splitOneNumberTest() {
        //given
        String inputNumber = "1,";
        //when
        String[] inputNumberSplit = inputNumber.split(",");
        //then
        assertThat(inputNumberSplit).containsExactly("1");

        assertThat(inputNumberSplit).contains("1");
    }

    @Test
    @DisplayName("String에서 (1,2)의 입력중 괄호를 제거")
    public void removeBracket() {
        //given
        String bracket = "(1,2)";
        //when
        String removeWord = bracket.substring(1, bracket.length() - 1);
        //then
        assertThat(removeWord).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt사용시 Exception 발생 테스트")
    public void chatAtExceptionTest() {
        //given
        String word = "abc";
        //when,then
        assertThatThrownBy(() -> word.charAt(word.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(word.length()));
        //람다식을 사용해서 word의 검사 및 에러메시지 확인

    }
}