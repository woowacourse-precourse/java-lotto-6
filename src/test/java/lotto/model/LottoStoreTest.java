package lotto.model;

import lotto.model.domain.Money;
import lotto.model.domain.lotto.Lottos;
import lotto.model.domain.lotto.lottogenerator.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {
    LottoStore lottoStore = new LottoStore(new RandomLottoGenerator());

    @Test
    @DisplayName("인당 구매 제한 금액은 10만원 입니다.")
    public void 구매_제한_금액_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoStore.purchase(new Money(101_000)));
    }

    @ParameterizedTest
    @DisplayName("입력한 값 만큼 로또를 판매한다.")
    @ValueSource(ints = {1000, 5000, 8000, 14000})
    public void 입력한_값_만큼_로또를_판매한다(int money) {
        //given
        //when
        Lottos lottos = lottoStore.purchase(new Money(money));

        //then
        Assertions.assertThat(lottos.getLottos().size())
                .isEqualTo(money / 1000);
    }

}