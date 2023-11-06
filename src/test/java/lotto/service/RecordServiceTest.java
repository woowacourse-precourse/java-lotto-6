package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RecordServiceTest {

    List<LottoTicket> bonusTickets = new ArrayList<>();

    @BeforeEach
    void init(){
        bonusTickets.add(new LottoTicket(List.of(1,2,3,4,5,6), 5, true));
    }


    @Test
    @DisplayName("일반적인 저장의 경우 보너스 경우를 제거한 경우!")
    void recordResultTest(){
        //given
        List<LottoTicket> lottoTickets;
        lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(List.of(1,2,3,4,5,6), 3, false));
        lottoTickets.add(new LottoTicket(List.of(3,4,5,6,7,8), 4, false));
        lottoTickets.add(new LottoTicket(List.of(1,2,3,4,5,6), 5, false));
        lottoTickets.add(new LottoTicket(List.of(1,2,3,4,5,6), 6, false));
        //when
        recordResult(lottoTickets);
        //then
        Assertions.assertThat(Result.FIFTH.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.FORTH.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.THIRD.getResultCount()).isEqualTo(1);
        Assertions.assertThat(Result.FIRST.getResultCount()).isEqualTo(1);
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

        public int getSameCount() {
            return sameCount;
        }

        public boolean isBonus() {
            return bonus;
        }
    }

    public void recordResult(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            for (Result value : Result.values()) {
                recordProcess(lottoTicket, value);
            }
        }
    }

    private void recordProcess(LottoTicket lottoTicket, Result value) {
        if (lottoTicket.getSameCount() == value.getSameCount()) {
            addResultCount(lottoTicket, value);
        }
    }

    private void addResultCount(LottoTicket lottoTicket, Result value) {
        if (checkIsSecond(lottoTicket, value)) {
            Result.SECOND.addCount();
            return;
        }
        if (isNoBonus(lottoTicket, value))
            value.addCount();
    }

    private boolean isNoBonus(LottoTicket lottoTicket, Result value) {
        return !lottoTicket.isBonus() && !value.isBonus();
    }


    private boolean isSameCountFive(Result value) {
        return value.getSameCount() == SAME_COUNT_FIVE.getNumber();
    }

    private boolean checkIsSecond(LottoTicket lottoTicket, Result value) {
        return lottoTicket.isBonus() && value.isBonus();
    }

}