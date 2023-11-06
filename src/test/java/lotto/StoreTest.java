package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Store;
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
    void inputNotDividedMoneyByThousand() {
        Store store = new Store();
        assertThatThrownBy(() -> {
            store.sellLottos(9500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000으로 가격이 나누어 떨어져야 합니다.");
    }
}