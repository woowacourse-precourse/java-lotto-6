package study;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
    List<String> lists;
    @BeforeEach
    void setUp() {
        lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
    }

    @Test
    @DisplayName("문자열 자르기 테스트_일치")
    void splitStringEqulas() {
        String input = "1,2";
        assertEquals(List.of(input.split(",")), lists);
    }

    @Test
    @DisplayName("문자열 자르기 테스트_포함")
    void splitStringContains() {
        String input = "1,2";
        assertTrue(List.of(input.split(",")).contains("1"));
    }

    @Test
    @DisplayName("문자열 자르기 테스트_정확하게_포함")
    void splitStringContainsExactly() {
        String input = "1,2";
        assertThat(List.of(input.split(","))).containsExactly("1","2");
    }

    @ParameterizedTest
    @CsvSource(value = {"(1,2):1,2"}, delimiter = ':')
    void 문자열_추출_테스트(String input, String expect) {
        assertEquals(input.substring(1,input.length() - 1), expect);
    }

    @Test
    @DisplayName("특정 위치의 문자 추출 테스트")
    void findSpecificLocationChar() {
        String input = "a,b,c";
        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자 추출 테스트_assertThatThrownBy")
    void findSpecificLocationChar_assertThatThrownBy() {
    String  input = "abc";
        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @ParameterizedTest
    @DisplayName("특정 위치의 문자 추출 테스트")
    @ValueSource(strings = "abc")
    void findSpecificLocationChar_assertThatExceptionOfType(String input) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(4))
                .withMessageMatching("String index out of range: 4");
    }

}
