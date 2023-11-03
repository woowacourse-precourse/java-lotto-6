package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\",\"로 split이 잘 되는지 검증하는 테스트")
    public void splitTest() {
        //given
        String testSentence = "1,2";

        //when
        String[] testNumbers = testSentence.split(",");

        //then
        assertThat(testNumbers)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("\",\"로 split할 항목이 없는 경우 반환 검증 테스트")
    public void splitNothingTest() {
        //given
        String testSentence = "1";

        //when
        String[] testNumbers = testSentence.split(",");

        //then
        assertThat(testNumbers)
                .containsExactly("1");
    }

    @Test
    @DisplayName("substring으로 불필요한 괄호 제거 테스트")
    public void substringTest() {
        //given
        String testSentence = "(1,2)";

        //when
        testSentence = testSentence.substring(1, testSentence.length() - 1);
        String[] testNumbers = testSentence.split(",");


        //then
        assertThat(testNumbers)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("chatAt 메서드로 문자 가져오는 테스트")
    public void charAtTest(){
        //given
        String testSentence = "abc";
        int index = 0;

        //when
        Character alphabet = testSentence.charAt(index);

        //then
        assertThat(alphabet)
                .isEqualTo('a');
    }

    @Test
    @DisplayName("chatAt 메서드가 잘못된 index에 접근하는 경우에 대한 테스트")
    public void outOfBoundssExceptionTest(){
        //given
        String testSentence = "abc";
        int index = 10;


        //when

        //then
        assertThatThrownBy(() -> {
            char alphabet = testSentence.charAt(index);
            assertThat(alphabet).isEqualTo('a');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", index);
    }
}
