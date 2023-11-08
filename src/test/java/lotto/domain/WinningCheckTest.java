package lotto.domain;

import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import lotto.domain.vendingMachine.lotto.Lotto;
import lotto.domain.winningManager.RateOfReturn;
import lotto.domain.winningManager.WinningCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WinningCheckTest {
    @DisplayName("로또 추첨 테스트")
    @Test
    public void 로또_추첨_테스트_1등(){
        //given
        WinningCheck winningCheck = new WinningCheck();
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = List.of(lotto);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1,2,3,4,5,6),7);
        //when
        HashMap<Integer, Integer> result = winningCheck.checkRanks(lottos, lottoDraw);
        //then
        Integer rankOneCount = result.get(1);
        assertEquals(1 , rankOneCount);
    }
    @DisplayName("수익률 테스트")
    @Test
    public void 수익률_테스트(){
        //given
        WinningCheck winningCheck = new WinningCheck();
        RateOfReturn rateOfReturn = new RateOfReturn();
        Lotto lotto = Lotto.of(List.of(1,2,3,44,23,13));
        List<Lotto> lottos = List.of(lotto);

        LottoDraw lottoDraw = LottoDraw.of(List.of(1,2,3,4,5,6),7);
        //when
        HashMap<Integer, Integer> result = winningCheck.checkRanks(lottos, lottoDraw);
        //then
        double ofReturn = rateOfReturn.calculateRateOfReturn(result, lottos.size());
        assertEquals(500.0 , ofReturn);
    }

}