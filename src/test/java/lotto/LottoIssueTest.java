package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.dto.LottoPurchase;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssueTest {

    @DisplayName("로또 금액을 입력하면, 그 금액에 맞는 개수의 로또가 발행된다.")
    @Test
    void buyLotto() {
        // given
        int purchasePrice = 3000;
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        LottoPurchase lottoPurchase = LottoPurchase.from(purchasePrice);
        int lottoCount = purchasePrice / LottoPurchase.LOTTO_PRICE;

        // when
        LottoTicket lottoTicket = lottoTicketMachine.getLottoTicket(lottoPurchase);

        // then
        assertThat(lottoTicket.getLottoCount()).isEqualTo(lottoCount);
        assertThat(lottoTicket.getLotto()).hasSize(lottoCount);
    }

}
