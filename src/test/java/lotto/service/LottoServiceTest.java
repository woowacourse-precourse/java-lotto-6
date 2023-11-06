package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {





    @Test
    @DisplayName("현재 로또 티켓이 당첨 번호를 가지고 있나?")
    void nowLottoTicketContainWinNumberTest(){
        //given
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6),0,false);
        int lottoWinNumber = 3;

        //when
        nowLottoTicketContainWinNumber(lottoTicket, lottoWinNumber);

        //then
        Assertions.assertThat(lottoTicket.getSameCount()).isEqualTo(1);
    }


    @Test
    @DisplayName("현재 로또 티켓이 5개 (2,3 등인 상황) 에서 보너스 번호 처리 하는 법 테스트")
    void nowLottoTicketHasBonusNumber(){
        //given
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6),5,false);
        int bonusNumber = 3;

        //when
        nowLottoTicketHasBonusNumber(lottoTicket, bonusNumber);

        //then
        Assertions.assertThat(lottoTicket.isBonus()).isEqualTo(true);
    }



    static class LottoTicket{
        private final List<Integer> numbers;

        private int sameCount;

        private boolean bonus;

        public LottoTicket(List<Integer> numbers, int sameCount, boolean bonus) {
            this.numbers = numbers;
            this.sameCount = sameCount;
            this.bonus = bonus;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void addSameCount() {
            this.sameCount++;
        }

        public int getSameCount() {
            return sameCount;
        }

        public boolean isBonus() {
            return bonus;
        }

        public void hasBonus() {
            this.bonus = true;
        }

    }

    private void nowLottoTicketContainWinNumber(LottoTicket lottoTicket,
        Integer lottoWinNumber) {
        if (lottoTicket.getNumbers().contains(lottoWinNumber)) {
            lottoTicket.addSameCount();
        }
    }


    private void nowLottoTicketHasBonusNumber(LottoTicket lottoTicket, Integer bonusNumber
        ) {
        if (lottoTicket.getSameCount() == SAME_COUNT_FIVE.getNumber() && lottoTicket.getNumbers()
            .contains(bonusNumber)) {
            lottoTicket.hasBonus();
        }
    }

}