package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구매 성공")
    void buyLottos() {
        //given
        List<Integer> numbers = List.of(1, 3, 5, 7, 13, 9);
        LottoStore lottoStore = new LottoStore(new TestNumberGenerator(numbers));
        Money money = new Money(10000);
        int purchaseLottoCount = money.getPurchaseLottoCount();

        //when
        List<Lotto> lottos = lottoStore.buyLotto(money);

        //then
        assertThat(lottos).hasSize(purchaseLottoCount);
        assertThat(lottos.get(0).getNumbers()).isEqualTo(numbers);
    }

}