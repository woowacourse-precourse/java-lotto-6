package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
    @DisplayName("split 테스트")
    @Nested
    class splitTest {
        @Test
        @DisplayName("2개 값 쉼표기준 나눴을 때 결과확인")
        void twoValueSplitTest() {
            String testCase = "1,2";

            //split이 이 상황에 잘 동작함을 알 수 있음
            assertThat(testCase.split(",")).contains("2", "1");
            assertThat(testCase.split(",")).containsExactly("1", "2");
        }

        @Test
        @DisplayName("공백을 포함한 값들 쉼표기준 나눴을 때 결과확인")
        void splitStringIncludeBlank() {
            String testCase = "1, ,3";

            //split이 이 상황에 잘 동작함을 알 수 있음
            assertThat(testCase.split(",")).containsExactly("1", " ", "3");
        }

        @Test
        @DisplayName("공백을 포함한 값들 쉼표기준 나눴을 때 결과확인2")
        void splitStringIncludeBlank2() {
            String testCase = "1,,3";

            //split이 이 상황에 잘 동작함을 알 수 있음
            assertThat(testCase.split(",")).containsExactly("1", "", "3");
        }

        @Test
        @DisplayName("1개 값 쉼표기준으로 나눴을 때 결과확인")
        void oneValueSplitTest() {
            String testCase = "1";

            //split이 하나의 원소만 가질 때도 잘 동작함을 알 수 있음
            assertThat(testCase.split(",")).contains("1");
        }

        @Test
        @DisplayName("맨 마지막에 쉼포가 있을 경우 결과확인")
        void lastIdxIsRegex() {
            String testCase = "1,";

            //split이 쉼표가 마지막에 붙어있을 때는 무시한다는 걸 알 수 있음
            assertThat(testCase.split(",")).contains("1");
        }

        @Test
        @DisplayName("맨 앞에 쉼포가 있을 경우 결과확인")
        void firstIdxIsRegex() {
            String testCase = ",1";

            //split이 쉼표가 앞에 붙어있을 때는 공백을 포함한다는 걸 알 수 있음
            assertThat(testCase.split(",")).containsExactly("", "1");
        }
    }

    @Test
    @DisplayName("subString 테스트")
    void subStringTest() {
        String testCase = "(1,2)";
        int startIdx = 1;
        int endIdx = testCase.length() - 1;

        //begin 인덱스는 포함되고, end 인덱스는 포함되지 않는 걸 확인가능
        assertThat(testCase.substring(startIdx, endIdx)).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("charAt 테스트")
    class CharAtTest {
        @Test
        @DisplayName("특정 위치 문자열 가져오기")
        void goodCase() {
            String input = "abc";

            assertThat(input.charAt(0)).isEqualTo('a');
            assertThat(input.charAt(1)).isEqualTo('b');
            assertThat(input.charAt(2)).isEqualTo('c');
        }

        @ParameterizedTest
        @CsvSource(value = {"abc", "asdf", "asdfg", "asdfgh", "안녕안녕테스트", "여덟글자를테스트"})
        @DisplayName("범위를 초과했을 때 예외 발생")
        void rangeOverException(String testCase) {
            int idx = testCase.length();

            //위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하고 메시지도 다음과 같이 나오는 걸 확인가능
            assertThatThrownBy(() -> testCase.charAt(idx))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("index");

            //예외메시지
            //String index out of range: 3
            //...
            //String index out of range: 6
            //index 7, length 7
            //index 8, length 8

            //다른 방식의 테스트코드
//            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
//                    .isThrownBy(() -> input.charAt(idx))
//                            .withMessageContaining("index", "range");
        }
    }
}
