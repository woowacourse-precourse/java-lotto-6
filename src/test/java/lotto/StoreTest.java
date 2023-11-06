package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {
    @DisplayName("입력금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void buyLottoWithChange() {
        Store store = new Store();
        assertThatThrownBy(() -> store.getLotto(13400))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 / 1000 만큼의 로또를 발급한다.")
    @Test
    void buyLotto() {
        Store store = new Store();
        List<Lotto> lottos = store.getLotto(12000);
        assertThat(lottos.size()).isEqualTo(12);
    }
}
