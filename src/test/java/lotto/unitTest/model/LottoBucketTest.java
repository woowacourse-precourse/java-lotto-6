package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import lotto.model.LottoBucket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBucketTest {

    @ValueSource(ints = {1, 10})
    @ParameterizedTest
    void 로또_바구니의_로또_개수는_구입_개수와_같다(int purchasedLottoAmount) {
        LottoBucket lottoBucket = new LottoBucket(purchasedLottoAmount);

        int lottoAmountOfLottoBucket = lottoBucket.getLottoAmount();

        assertThat(lottoAmountOfLottoBucket).isEqualTo(purchasedLottoAmount);
    }

    @ParameterizedTest
    @CsvSource({"5, -1", "5, 5"})
    void 로또_바구니의_범위를_벗어난_로또를_꺼내면_예외를_발생시킨다(int lottoAmount, int index) {
        LottoBucket lottoBucket = new LottoBucket(lottoAmount);

        assertThatThrownBy(() -> lottoBucket.getLotto(index)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @CsvSource({"5, 0", "5, 4"})
    void 로또_바구니의_범위에_있는_로또를_꺼낸다(int lottoAmount, int index) {
        LottoBucket lottoBucket = new LottoBucket(lottoAmount);

        assertThat(lottoBucket.getLotto(index)).isInstanceOf(Lotto.class);
    }
}