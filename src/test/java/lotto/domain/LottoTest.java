package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void getNumbers() {
        // given
        Lotto case1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> result1 = case1.getNumbers();

        // then
        assertThat(result1).as("case1").isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void contains() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int case1 = 1;
        int case2 = 45;

        // when
        boolean result1 = lotto.contains(case1);
        boolean result2 = lotto.contains(case2);

        // then
        assertThat(result1).as("case1").isEqualTo(true);
        assertThat(result2).as("case2").isEqualTo(false);
    }

    @Test
    void testToString() {
        // given
        Lotto case1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = case1.toString();

        // then
        assertThat(result).as("case1").isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}