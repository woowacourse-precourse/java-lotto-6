package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    // 요구사항1
    @Test
    @DisplayName("쉼표(,)로 잘 분리되는지 확인합니다.")
    void checkSplitData(){
        // given
        String number = "1,2";

        // when
        String[] numbers = number.split(",");

        // then
        assertThat(numbers).contains("1","2");
    }

    @Test
    @DisplayName("'1'을 split 했을 때 1만을 포함하는 배열이 반환되는지 확인합니다.")
    void checkSplitOneArray(){
        // given
        String number = "1";

        // when
        String[] numbers = number.split(",");

        // then
        assertThat(numbers).containsExactly("1");
    }

    // 요구사항 2
    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 '1,2'가 반환되는지 확인합니다.")
    void checkSubstringData(){
        // given
        String roundBracketsNumber = "(1,2)";

        // when
        String number = roundBracketsNumber.substring(1,4);

        // then
        assertThat(number).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("'abc'값에서 특정 위치의 문자를 확인한다.")
    void checkZeroIndexInput(){
        // given
        String input = "abc";

        // when
        char a = input.charAt(0);

        // then
        assertThat(a).isEqualTo('a');
    }

    @Test
    @DisplayName("'abc'값에서 특정 위치의 문자를 벗어나면 예외를 발생시킨다.")
    void checkThreeIndexInputException(){
        // given
        String input = "abc";

        // when, then
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}