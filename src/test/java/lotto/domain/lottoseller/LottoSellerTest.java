package lotto.domain.lottoseller;

import static lotto.domain.constant.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    @DisplayName("LottoGenerator을 이용해 생성한다.")
    @Test
    void createByLottoGenerator() {
        // given
        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        // when
        LottoSeller lottoSeller = new LottoSeller(lottoGenerator);

        // then
        assertThat(lottoSeller).isInstanceOf(LottoSeller.class);
    }

    @DisplayName("입력받은 금액 만큼 로또를 판매한다.")
    @Test
    void sellLottoForGivenAmount() {
        // given
        LottoSeller lottoSeller = new LottoSeller(new RandomLottoGenerator());
        Money money = Money.valueOf(5000);

        // when
        List<Lotto> lottos = lottoSeller.sell(money);

        // then
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("잔액이 부족할 경우 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] : money = {0}")
    @ValueSource(ints = {700, 1300, 1700, 2100})
    void cannotSell_whenLackOfBalance(final int moneyValue) {
        // given
        LottoSeller lottoSeller = new LottoSeller(new RandomLottoGenerator());
        Money money = Money.valueOf(moneyValue);

        // when, then
        assertThatThrownBy(() -> lottoSeller.sell(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(
                String.format("잔액 %d원 으로는 1000원의 로또를 구매하실 수 없습니다.",
                    moneyValue % LOTTO_PRICE.getValue())
            );
    }
}