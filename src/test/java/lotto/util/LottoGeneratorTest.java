package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void buyLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertAll(
                () -> assertThat(lottoGenerator.buyLottos(LottoPurchaseAmount.valueOf(999)).size()).isEqualTo(0),
                () -> assertThat(lottoGenerator.buyLottos(LottoPurchaseAmount.valueOf(10100)).size()).isEqualTo(10)
        );

    }
}