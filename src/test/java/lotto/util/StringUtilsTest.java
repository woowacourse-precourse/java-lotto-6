package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {
    @Test
    @DisplayName("문자열을 쉼표(,)로 구분하여 파싱한다.")
    void splitCommaToListString() {
        // given
        String numbers = "1,2,3,4,5";

        // when
        List<String> results = StringUtils.splitCommaToListString(numbers);

        // then
        assertThat(results).hasSize(5)
                .containsSequence("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("String타입의 List를 Integer타입의 List로 변환한다.")
    void convertStringListToIntegerList() {
        // given
        List<String> strings = List.of("1", "2", "3", "4", "5");

        // when
        List<Integer> integers = StringUtils.convertStringListToIntegerList(strings);

        // then
        assertThat(integers).hasSize(5)
                .containsSequence(1,2,3,4,5);
    }

    @Test
    @DisplayName("숫자에 3자리 마다 쉼표(,)를 넣어 표기한다.")
    void convertToMoneyFormat() {
        // given
        int money = 1_000_000;

        // when
        String moneyFormat = StringUtils.convertToMoneyFormat(money);

        // then
        assertThat(moneyFormat).isEqualTo("1,000,000");
    }
}