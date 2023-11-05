package lotto.service;

import static lotto.service.PurchaseLotto.PURCHASE_COST_NAN_MSG;
import static lotto.service.PurchaseLotto.PURCHASE_COST_RANGE_MSG;
import static lotto.service.PurchaseLotto.PURCHASE_COST_UNIT_MSG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoTest {
    @DisplayName("로또 원하는 개수 만큼 구입")
    @Test
    void purchaseLottoN() {
        String cost = "8000";
        int numberOfLotto = 8;

        List<Lotto> lottos = new PurchaseLotto().purchase(cost);
        lottos.stream().forEach(lotto -> System.out.println(lotto));
        assertThat(lottos.size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("잘못된 로또 개수 입력시 예외가 발생한다.")
    @Test
    void invalidPurchaseCost() {
        String[] inputs = {"1.23", "10000000", "1001"};
        String[] outputs = {PURCHASE_COST_NAN_MSG, PURCHASE_COST_RANGE_MSG, PURCHASE_COST_UNIT_MSG};

        for (int i = 0; i < 3; i++) {
            String input = inputs[i];
            assertThatThrownBy(() -> new PurchaseLotto().purchase(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(outputs[i]);
        }
    }
}
