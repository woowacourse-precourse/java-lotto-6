package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketFactoryTest {

    @DisplayName("로또 티켓 정상 발행 테스트")
    @Test
    void LottoTicketFactoryTest(){
       LottoTicket lottoTicket =  LottoTicketFactory.generateTicket(5); //when

       assertThat(lottoTicket.getLottos().size()).isEqualTo(5); //then
    }
}