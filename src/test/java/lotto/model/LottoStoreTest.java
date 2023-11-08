package lotto.model;

import static lotto.constant.LottoConfig.PURCHASE_PRICE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @DisplayName("돈을 입력하면 그에 맞게 로또를 발행한다.")
    @Test
    void publishLotto() {
        int money = 8000;
        int ticketNumber = money / PURCHASE_PRICE.getValue();

        Lottos lottos =  LottoStore.publishLotto(money);

        Assertions.assertThat(lottos.getSize()).isEqualTo(ticketNumber);
    }
}