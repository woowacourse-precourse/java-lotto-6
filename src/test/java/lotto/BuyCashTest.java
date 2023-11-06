package lotto;

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
}
