package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringTest {

    //요구사항1
    @ParameterizedTest
    @DisplayName("split 메서드 테스트")
    @MethodSource("inputAndSeperatedListProvider")
    public void 문자열_나누기_테스트(String input, String[] expectedResult) {
        //when
        String[] actualResult = input.split(",");

        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> inputAndSeperatedListProvider() {
        return Stream.of(
                Arguments.arguments("1,2", new String[]{"1", "2"}),
                Arguments.arguments("1", new String[]{"1"})
        );
    }

    //요구사항2
    @Test
    @DisplayName("substring 메서드 테스트")
    public void 문자열_일부_뽑기_테스트() {
        //given
        String input = "(1,2)";
        String expectedResult = "1,2";

        //when
        String actualResult = input.substring(1, 4);

        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    //요구사항3
    @Test
    @DisplayName("charAt() 메서드 index 범위 통과 테스트")
    public void 문자뽑기_성공_테스트() {
        //given
        String input = "abc";

        //when
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);

        //then
        assertThat(firstChar == 'a').isTrue();
        assertThat(secondChar == 'b').isTrue();
        assertThat(thirdChar == 'c').isTrue();
    }

    @Test
    @DisplayName("charAt() 메서드 index 범위 초과로 StringIndexOutOfBoundsException 발생 테스트")
    public void 문자_뽑기_실패_테스트() {
        //given
        String input = "abc";

        //then
        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
