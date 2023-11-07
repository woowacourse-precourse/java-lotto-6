package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @DisplayName("문자열 배열을 숫자 리스트로 타입 변환한다.")
    @Test
    void convertTypeStringToInteger() {
        // given
        String[] inputNumbers = {"1", "2", "3", "4", "5", "6"};

        // when
        List<Integer> numbers = Controller.convertType(inputNumbers);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }
}
