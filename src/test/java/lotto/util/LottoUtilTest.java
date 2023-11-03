package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoUtilTest {
    @DisplayName("정렬 기능 테스트")
    @Test
    void sortByAscTest() {
        List<Integer> actual = Arrays.asList(6, 5, 4, 3, 2, 1);
        LottoUtil.sortByAsc(actual);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, actual);
    }
}
