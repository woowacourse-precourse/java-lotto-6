package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoTicketFactoryTest {

    @DisplayName("로또 티켓 정상 발행 테스트")
    @Test
    void LottoTicketFactoryTest(){
       LottoTicket lottoTicket =  LottoTicketFactory.generateTicket(5); //when

       assertThat(lottoTicket.getLottos().size()).isEqualTo(5); //then
    }

    @DisplayName("발급한 로또 티켓 변형 불가 테스트")
    @Test
    void cannotFixTicketTest(){
        LottoTicket lottoTicket =  LottoTicketFactory.generateTicket(5);

        assertThatThrownBy(() ->lottoTicket.getLottos().add(new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() ->lottoTicket.getLottos().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}