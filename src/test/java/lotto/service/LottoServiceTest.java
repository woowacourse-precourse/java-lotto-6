package lotto.service;


import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void init(){
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("현재 로또 티켓이 당첨 번호를 가지고 있나?")
    void nowLottoTicketHasWinNumbersTest() {
        //given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(List.of(3, 4, 5, 6, 7, 8)));
        List<Integer> winNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber=10;
        //when
        lottoService.lottoGameProcess(lottoTickets, winNumbers,bonusNumber);
        //then
        Assertions.assertThat(lottoTickets.get(0).getSameCount()).isEqualTo(6);
        Assertions.assertThat(lottoTickets.get(1).getSameCount()).isEqualTo(4);
    }


    @Test
    @DisplayName("현재 로또 티켓이 5개 (2,3 등인 상황) 에서 보너스 번호 처리 하는 법 테스트")
    void nowLottoTicketHasBonusNumber() {
        //given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 8)));
        List<Integer> winNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber=8;

        //when
        lottoService.lottoGameProcess(lottoTickets, winNumbers, bonusNumber);

        //then
        Assertions.assertThat(lottoTickets.get(0).isBonus()).isEqualTo(true);
    }

}
