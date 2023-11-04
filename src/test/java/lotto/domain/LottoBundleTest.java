package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    @Test
    @DisplayName("정상적으로 로또 뭉치를 만든다.")
    void create_lotto_bundle() {
        // given
        List<List<Integer>> lotteries = Arrays.asList(
                Arrays.asList(1, 3, 5, 7, 9, 43),
                Arrays.asList(2, 4, 6, 8, 10, 11),
                Arrays.asList(17, 25, 41, 31, 35, 3));

        // when // then
        assertThatCode(() -> new LottoBundle(lotteries))
                .doesNotThrowAnyException();
    }
}
