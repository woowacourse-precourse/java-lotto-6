package lotto.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class FormatConverterTest {
    private static final String WINNING_NUMBERS1 = "1,2,3,4,5,6";
    private static final String WINNING_NUMBERS2 = "40,41,42,43,44,45";
    private static final String WINNING_NUMBERS3 = "1,3,16,28,37,45";
    private static final String WINNING_NUMBERS4 = "2,8,10,15,22,36";

    @DisplayName("쉼표로 구분된 숫자 문자열 값들을 정수형의 리스트로 변환한다.")
    @Test
    void toIntegerListWithComma() {
        // given, when
        List<Integer> result1 = FormatConverter.toIntegerListFromStringWithComma(WINNING_NUMBERS1);
        List<Integer> result2 = FormatConverter.toIntegerListFromStringWithComma(WINNING_NUMBERS2);
        List<Integer> result3 = FormatConverter.toIntegerListFromStringWithComma(WINNING_NUMBERS3);
        List<Integer> result4 = FormatConverter.toIntegerListFromStringWithComma(WINNING_NUMBERS4);

        // then
        assertThat(result1).hasSize(COUNT)
                .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(result2).hasSize(COUNT)
                .containsExactly(40, 41, 42, 43, 44, 45);
        assertThat(result3).hasSize(COUNT)
                .containsExactly(1, 3, 16, 28, 37, 45);
        assertThat(result4).hasSize(COUNT)
                .containsExactly(2, 8, 10, 15, 22, 36);
    }
}
