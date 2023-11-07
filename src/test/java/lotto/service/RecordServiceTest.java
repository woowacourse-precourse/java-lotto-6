package lotto.service;


import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecordServiceTest {

    private RecordService recordService;

    @BeforeEach
    void init() {
        recordService = new RecordService();
        for (Result value : Result.values()) {
            value.init();
        }
    }


    @Test
    @DisplayName("일반적인 저장의 경우 보너스 경우를 제거한 경우!")
    void recordResultTest() {
        //given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(List.of(3, 4, 5, 6, 7, 8)));
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));

        madeTestCaseNoBonusLottoTickets(lottoTickets);

        //when
        recordService.recordResult(lottoTickets);
        //then
        Assertions.assertThat(Result.FIFTH.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.FORTH.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.THIRD.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.FIRST.getResultCount()).isEqualTo(1);
    }

    private void madeTestCaseNoBonusLottoTickets(List<LottoTicket> lottoTickets) {
        for(int ticketCount = 0; ticketCount<lottoTickets.size(); ticketCount++)
            for (int repeat = 0; repeat < ticketCount + 3; repeat++) {
                lottoTickets.get(ticketCount).addSameCount();
            }
    }


    @Test
    @DisplayName("보너스 번호가 생길 경우에 대한 테스트!")
    void recordBonusResultTest() {
        //given
        List<LottoTicket> bonusTickets = new ArrayList<>();

        bonusTickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));
        bonusTickets.add(new LottoTicket(List.of(3, 4, 5, 6, 7, 8)));

        madeTestCaseBonusLottoTickets(bonusTickets);

        //when
        recordService.recordResult(bonusTickets);
        //then

        Assertions.assertThat(Result.SECOND.getResultCount()).isEqualTo(2);
    }

    private void madeTestCaseBonusLottoTickets(List<LottoTicket> bonusTickets) {
        for (LottoTicket bonusTicket : bonusTickets) {
            for (int repeat = 0; repeat < NumberConstant.SAME_COUNT_FIVE.getNumber(); repeat++) {
                bonusTicket.addSameCount();
            }
            bonusTicket.hasBonus();
        }
    }

}