package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    private Converter converter;

    @Test
    @DisplayName("문자열이 정수로 바뀌는지 테스트")
    void stringToIntegerTest(){
        //given
        String input = "123";
        int answer = 123;
        //when
        int result = converter.stringToInteger(input);

        //then
        assertEquals(result, 123);

    }

}