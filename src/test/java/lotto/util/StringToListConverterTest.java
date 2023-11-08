package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToListConverterTest {
    private final StringToListConverter stringToListConverter = new StringToListConverter();

    @Test
    @DisplayName("문자열 정수형 리스트로 잘 반환 되는지 확인")
    void stringToListConverterTest() {
        //given
        String input = "1,2,3,4,5,6";
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        List<Integer> result = StringToListConverter.stringToList(input);
        //then
        assertEquals(answer, result);
    }

}