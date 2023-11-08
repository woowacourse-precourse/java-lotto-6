package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    @DisplayName("주어진 금액으로 올바른 로또 갯수를 사는지 테스트")
    void countLottoTest() {
        Money money = new Money("14000");
        Store store = new Store(money);
        int expectedCount = 14;

        int actualCount = store.getLottoCount();

        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("Store에서 생성한 로또가 정상적인 로또인지 테스트")
    void makeLottoTest() {
        Store store = new Store(new Money("1000"));
        LottoTickets lottoTickets = store.getLottoTickets();
        Lotto lotto = lottoTickets.getLotto().get(0);

        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers()).hasSize(6);
    }
}