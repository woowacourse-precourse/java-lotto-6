package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.error.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {
    @Test
    @DisplayName("금액에 맞춰 1000원당 로또를 하나씩 발행 해준다.")
    void sellLottosAccordingToMoney() {
        Integer money = 10000;
        Store store = new Store();
        List<Lotto> lottos = store.sellLottos(money);
        assertThat(lottos.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("지불 금액은 1000원으로 가격이 나누어 떨어져야 한다.")
    void inputNotDividedMoneyByThousand() {
        Store store = new Store();
        assertThatThrownBy(() -> {
            store.sellLottos(9500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.THOUSAND_MULTIPLE_PRICE);
    }
}