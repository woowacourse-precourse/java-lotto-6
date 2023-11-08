package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("constructor() : 로또 티켓 발급 테스트")
    @Test
    void lottoTicket_constructor_success() throws Exception {
        //given
        Lotto lottoNumbers1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoNumbers2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        LottoTicket lottoTicket = new LottoTicket(List.of(lottoNumbers1, lottoNumbers2));

        //when //then
        assertThat(lottoTicket.lottoTicket()).hasSize(2);
    }
}