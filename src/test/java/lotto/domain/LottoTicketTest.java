package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.mock.MockNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    NumberGenerator mockNumberGenerator;
    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        mockNumberGenerator = new MockNumberGenerator();
        PurchasePrice purchasePrice = PurchasePrice.from("1000");
        lottoTicket = LottoTicket.of(purchasePrice, mockNumberGenerator);
    }

    @DisplayName("로또 티켓은 번호생성기로 생성된 로또 번호를 가지고 있다.")
    @Test
    void lottoTicketTest() {
        // when
        Lotto generatedLotto = new Lotto(mockNumberGenerator.generate());

        // then
        assertThat(lottoTicket.getLottoTicket()).contains(generatedLotto);
    }

    @DisplayName("1000원만 구입했을 때 로또 티켓의 번호 수는 1개이다.")
    @Test
    void lottoTicketCountTest() {
        assertThat(lottoTicket.getLottoCount()).isEqualTo(1);
    }
}