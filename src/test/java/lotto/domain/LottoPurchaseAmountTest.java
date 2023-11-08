package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 8_000, 10_000})
    void LottoPurchaseAmount_객체_생성(int input) {
        assertThat(LottoPurchaseAmount.create(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 999})
    void 로또_구입금액이_로또_한장_가격_보다_작으면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 최소 구매 금액은 1,000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1_001, 2_222, 3_030, 10_001})
    void 로또_구입금액에서_잔돈이_남으면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 1,000원 단위로 구매 하셔야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1_000, 1", "4_000, 4", "6_000, 6", "8_000, 8"})
    void 로또_구입_개수를_반환한다(int input, int expected) {
        assertThat(LottoPurchaseAmount.create(input).getLottoCount().count())
                .isEqualTo(expected);
    }
}
