package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StringConverterTest {
    // 각 테스트할 메소드들의 파라미터는 검증이 완료됐음이 precondition이므로
    // specification을 위한하는 경우는 테스트하지 않는다.

    @Test
    void testToInt() {
        String[] testCases = {
                "-1415214", "-1", "0", "1", "15", "135134124"
        };
        int[] expected = {
                -1415214, -1, 0, 1, 15, 135134124
        };

        for (int i = 0; i < testCases.length; i++) {
            assertThat(StringConverter.toInt(testCases[i])).isEqualTo(expected[i]);
        }
    }

    @Test
    void testConvertWinningNumbers() {
        String[] testCases = {
                "1,2,3,4,5",
                "5,6,7,8,9",
                "0,1,2,3,4",
                "56,57,58,59,"
        };
        List<Integer[]> expected = Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5 },
                new Integer[] { 5, 6, 7, 8, 9 },
                new Integer[] { 0, 1, 2, 3, 4 },
                new Integer[] { 56, 57, 58, 59 }
        );

        for (int i = 0; i < testCases.length; i++) {
            assertThat(StringConverter.convertWinningNumbers(testCases[i]))
                    .contains(expected.get(i));
        }
    }
}