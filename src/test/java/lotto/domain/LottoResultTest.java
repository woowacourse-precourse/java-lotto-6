package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {
    private LottoMoneyPrize lottoMoneyPrize;

    @Test
    @DisplayName("로또 결과 확인 테스트")
    void checkLottoResult() {
        //given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), // 3
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)), //3
                new Lotto(Arrays.asList(1, 2, 3, 24, 27, 41)), //5
                new Lotto(Arrays.asList(13, 17, 23, 25, 28, 44))  //6
        );

        List<Integer> randomWin = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        //when
        LottoMoneyPrize lottoMoneyPrize = new LottoMoneyPrize(lottos, randomWin, bonusNum);
        Map<LottoMoney, Integer> result = lottoMoneyPrize.getLottoMoneyPrize();

        //then
        assertEquals(1, result.get(LottoMoney.FIRST));
        assertEquals(1, result.get(LottoMoney.SECOND));
        assertEquals(2, result.get(LottoMoney.THIRD));
        assertEquals(0, result.get(LottoMoney.FOURTH));
        assertEquals(1, result.get(LottoMoney.FIFTH));
        assertEquals(1, result.get(LottoMoney.ZERO));

    }

}