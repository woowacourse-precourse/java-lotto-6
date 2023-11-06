package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;
import static lotto.constant.NumberConstant.ZERO;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {






    @ParameterizedTest
    @MethodSource("generate")
    @DisplayName("현재 로또 티켓이 당첨 번호를 가지고 있나?")
    void nowLottoTicketContainWinNumberTest(List<LottoTicket> lottoTickets,
        Integer lottoWinNumber, int ticketNumber){

        //when
        nowLottoTicketContainWinNumber(lottoTickets, lottoWinNumber, ticketNumber);

        //then
        Assertions.assertThat(lottoTickets.get(0).getSameCount()).isEqualTo(1);

    }


    static Stream<Arguments> generateLottoArgument(){
        return Stream.of(
            Arguments.of(List.of(new LottoTicket(List.of(1,2,3,4,5,6)), 3,0))
            );
    }



    private void nowLottoTicketHasWinNumber(List<LottoTicket> lottoTickets, List<Integer> lottoWinNumbers,
        int ticektNumber) {
        for (Integer lottoWinNumber : lottoWinNumbers) {
            nowLottoTicketContainWinNumber(lottoTickets, lottoWinNumber, ticektNumber);
        }
    }

    private void nowLottoTicketContainWinNumber(List<LottoTicket> lottoTickets,
        Integer lottoWinNumber, int ticketNumber) {
        if (lottoTickets.get(ticketNumber).getNumbers().contains(lottoWinNumber)) {
            lottoTickets.get(ticketNumber).addSameCount();
        }
    }


    private void nowLottoTicketHasBonusNumber(List<LottoTicket> lottoTickets, Integer bonusNumber,
        int ticketNumber) {
        if (lottoTickets.get(ticketNumber).getSameCount() == SAME_COUNT_FIVE.getNumber() && lottoTickets.get(ticketNumber).getNumbers()
            .contains(bonusNumber)) {
            lottoTickets.get(ticketNumber).hasBonus();
        }
    }


    @Test
    void calculateMoney() {
    }

    @Test
    void calculateYield() {
    }
}