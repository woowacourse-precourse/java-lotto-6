package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyCashTest {
    @DisplayName("로또 구매액이 적합한지를 검증하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {1001, -1500, 900, 0})
    void 로또구매_값_검증(long buyCash) {
        assertThatThrownBy(() -> new BuyCash(buyCash))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액에 따른 구매개수를 반환해주는 기능.(1000원 기준)")
    @ParameterizedTest
    @ValueSource(longs = {1000, 5000, 100000, 18000})
    void 로또_구매_개수(long cash) {
        long buyUnit = 1000;
        long expected = cash / buyUnit;

        BuyCash buyCash = new BuyCash(cash);

        assertThat(buyCash.getLottoAmount()).isEqualTo(expected);
    }
}
