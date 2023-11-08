package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 로또_개수에_따라_구매_시_필요한_금액을_계산한다() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        int cost = lottos.calculateTotalCost();

        assertThat(cost).isEqualTo(2000);
    }
}
