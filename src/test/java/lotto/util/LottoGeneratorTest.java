package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void buyLottos() {
        assertAll(
                () -> assertThat(LottoGenerator.buyLottos(LottoPurchaseAmount.valueOf(1000)).size()).isEqualTo(1),
                () -> assertThat(LottoGenerator.buyLottos(LottoPurchaseAmount.valueOf(150000)).size()).isEqualTo(150)
        );

    }
}