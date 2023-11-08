package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    @DisplayName("5000원을 입력 시 로또 5개를 구매합니다.")
    @Test
    void buyLottoByInputMoney() {
        List<Lotto> lottos =  LottoStore.buyLotto(new Money("5000"));
        assertThat(lottos).hasSize(5);
    }
}
