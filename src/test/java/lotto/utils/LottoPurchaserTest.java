package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import lotto.exception.LessThanLottoPriceException;
import lotto.utils.LottoPurchaser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaserTest {

    @DisplayName("로또 구입 금액에 맞는 로또 개수가 발행되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"8000,8", "2000,2", "7000,7", "9000,9"})
    void purchase(int input, int expected) {
        // given
        Money money = new Money(input);
        LottoPurchaser lottoPurchaser = new LottoPurchaser(money);
        int lottoSize = lottoPurchaser.purchase();

        assertThat(lottoSize).isEqualTo(expected);
    }

    @DisplayName("로또 구입 금액이 로또 가격보다 낮으면 안 된다.")
    @ParameterizedTest
    @ValueSource(ints = {900, 500, 300})
    void haveMoneyOverLottoPrice(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(LessThanLottoPriceException.class);
    }
}
