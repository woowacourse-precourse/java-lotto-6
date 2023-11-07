package lotto.util;

import static lotto.util.Utils.stringToIntegerSortedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListUtilsTest {

    @DisplayName("string 을 List<Integer> 로 변환하는 기능")
    @Test
    public void stringToIntegerList() {
        // given
        String inputLotto = "1,2,3,4,5,6";
        Utils listUtils = new Utils();

        // when
        List<Integer> lotto = stringToIntegerSortedList(inputLotto);

        // then
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, lotto);
    }
}
