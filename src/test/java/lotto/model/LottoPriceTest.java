package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void 로또가격의_배수값을_갖는_투자금액에_따라_구매가능한_로또_개수를_계산한다(int money, int expectedLottoCount) {
        LottoPrice lottoPrice = LottoPrice.STANDARD_PRICE;

        PurchasableLottoCount actualPurchasableLottoCount = lottoPrice.calculateLottoCount(money);

        PurchasableLottoCount expectedPurchasableLottoCount = PurchasableLottoCount.from(expectedLottoCount);
        assertThat(actualPurchasableLottoCount).isEqualTo(expectedPurchasableLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void 로또_최소_가격보다_낮은_투자금액으로는_구매가능한_로또_개수를_계산할_수_없다(int money) {
        LottoPrice lottoPrice = LottoPrice.STANDARD_PRICE;

        assertThatThrownBy(() -> lottoPrice.calculateLottoCount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 2001})
    void 로또가격의_배수값을_갖지_않는_투자금액으로는_구매가능한_로또_개수를_계산할_수_없다(int money) {
        LottoPrice lottoPrice = LottoPrice.STANDARD_PRICE;

        assertThatThrownBy(() -> lottoPrice.calculateLottoCount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1001})
    void 로또가격의_배수값을_갖지_않는_투자금액인지_검증할_수_있다(int money) {
        LottoPrice lottoPrice = LottoPrice.STANDARD_PRICE;

        assertThatThrownBy(() -> lottoPrice.validateDivisible(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_금액의_로또가격은_같은_객체이다() {
        LottoPrice actualLottoPrice = LottoPrice.STANDARD_PRICE;
        LottoPrice expectedLottoPrice = LottoPrice.STANDARD_PRICE;

        assertThat(actualLottoPrice).isSameAs(expectedLottoPrice);
    }

    @Test
    void 같은_금액의_로또_가격은_같은_해시코드를_가진다() {
        LottoPrice actualLottoPrice = LottoPrice.STANDARD_PRICE;
        LottoPrice expectedLottoPrice = LottoPrice.STANDARD_PRICE;

        assertThat(actualLottoPrice).hasSameHashCodeAs(expectedLottoPrice);
    }
}
