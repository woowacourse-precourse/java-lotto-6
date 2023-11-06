package lotto.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class UtilTest {

    @DisplayName("문자열 배열을 숫자 리스트로 변환한다.")
    @Test
    void 문자열_배열을_숫자_리스트로_변환() {
        // given
        String[] string = {"1", "2", "3", "4", "5", "6"};

        // when
        List<Integer> numbers = Util.stringToIntegerList(string);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }
}
