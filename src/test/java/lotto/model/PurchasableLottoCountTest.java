package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasableLottoCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    void 로또_구매_개수는_유효한_범위안에서_생성되면_예외가_발생하지_않는다(int count) {
        assertDoesNotThrow(() -> PurchasableLottoCount.from(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    void 로또_구매_개수는_유효한_범위안에_생성되지_않으면_예외가_발생한다(int count) {
        assertThatThrownBy(() -> PurchasableLottoCount.from(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구매_개수가_같으면_서로_같은_객체이다() {
        PurchasableLottoCount actualPurchasableLottoCount = PurchasableLottoCount.from(1);
        PurchasableLottoCount expectedPurchasableLottoCount = PurchasableLottoCount.from(1);

        assertThat(actualPurchasableLottoCount).isEqualTo(expectedPurchasableLottoCount);
    }

    @Test
    void 로또_구매_개수가_같지_않으면_서로_다른_객체이다() {
        PurchasableLottoCount actualPurchasableLottoCount = PurchasableLottoCount.from(1);
        PurchasableLottoCount expectedPurchasableLottoCount = PurchasableLottoCount.from(2);

        assertThat(actualPurchasableLottoCount).isNotEqualTo(expectedPurchasableLottoCount);
    }

    @Test
    void 로또_구매_개수가_같으면_서로_같은_해시코드를_가진다() {
        PurchasableLottoCount actualPurchasableLottoCount = PurchasableLottoCount.from(1);
        PurchasableLottoCount expectedPurchasableLottoCount = PurchasableLottoCount.from(1);

        assertThat(actualPurchasableLottoCount).hasSameHashCodeAs(expectedPurchasableLottoCount);
    }
}
