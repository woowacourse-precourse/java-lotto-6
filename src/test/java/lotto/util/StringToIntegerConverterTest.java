package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToIntegerConverterTest {
    private StringToIntegerConverter stringToIntegerConverter;

    @BeforeEach
    void setUp() {
        stringToIntegerConverter = new StringToIntegerConverter();
    }

    @Test
    @DisplayName("문자열이 정수로 바뀌는지 테스트")
    void stringToIntegerTest() {
        //given
        String input = "123";
        int answer = 123;
        //when
        int result = stringToIntegerConverter.stringToInteger(input);
        //then
        assertEquals(result, answer);

    }

}