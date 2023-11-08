package lotto.module.store;

import lotto.module.domain.PurchaseAmount;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.LottoNumberGenerator;
import lotto.module.lotto.UserLottoTicketGenerator;
import lotto.module.lotto.UserLottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setLottoStore() {
        LottoNumberGenerator lottoNumberGenerator = UserLottoTicketGenerator.newInstance();
        LottoTicketQuantityCalculator lottoTicketQuantityCalculator = LottoTicketQuantityCalculator.newInstance();

        lottoStore = LottoStore.of(lottoNumberGenerator, lottoTicketQuantityCalculator);
    }

    @Test
    void 복권_1장당_1000원에_구매_성공_테스트() {
        // given
        int payment = 5000;
        int expectedTicketCount = 5;
        PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(payment);

        // when
        UserLottoTickets userLottoTickets = lottoStore.purchaseLotto(purchaseAmount);
        List<Lotto> tickets = userLottoTickets.tickets();

        // then
        Assertions.assertThat(tickets.size())
                .isEqualTo(expectedTicketCount);
    }

}