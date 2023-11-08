package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {


    @Nested
    @DisplayName("String.split 메서드 테스트")
    class splitTest {

        @Test
        @DisplayName("1,2를 , 기준으로 split이 잘 되는지 테스트한다.")
        void split_했을떄_잘_분리되는지_테스트() {
            String input = "1,2";
            Assertions.assertThat(input.split(",")).contains("1","2");
        }

        @Test
        @DisplayName(" 1을 ,로 split 했을 때, 1만을 포함하는지 테스트한다.")
        void 기준점이없을때_잘_분리되는지_테스트(){
            String input = "1";
            Assertions.assertThat(input.split(",")).containsExactly("1");
        }
    }

    @Nested
    @DisplayName("String.subString 메서드 테스트")
    class SubStringTest {

        @Test
        @DisplayName("(1,2)값이 주어졌을떄, subString() 메소드를 활용 ()를 제거하고, 1,2 를 반환하는지 테스트한다.")
        void subString_메소드_테스트(){
            String input = "(1,2)";
            Assertions.assertThat(input.substring(input.indexOf("(")+1,input.indexOf(")"))).isEqualTo("1,2");
        }
    }


    @Nested
    @DisplayName("String.charAt 메서드 테스트")
    class charAtTest {

        @Test
        @DisplayName("charAt으로 특정 위치의 문자를 정상적으로 가져오는지 테스트한다.")
        void charAt_위치값_정상적인_경우_테스트() {
            String input = "a,b,c";
            Assertions.assertThat(input.charAt(2)).isEqualTo('b');
            Assertions.assertThat(input.charAt(4)).isEqualTo('c');
        }

        @Test
        @DisplayName("charAt으로 위치 값을 벗어나 예외를 반환하는지 테스트한다.")
        void charAt_위치값_벗어나는_경우_테스트() {
            String input = "a,b,c";
            Assertions.assertThatThrownBy(() -> {
                        input.charAt(input.length());
                    }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: " + input.length());

            assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        input.charAt(input.length());
                    }).withMessageMatching("String index out of range: " + input.length());
        }
    }
}
