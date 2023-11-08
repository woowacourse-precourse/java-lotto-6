package lotto.domain.lotto;

import lotto.domain.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoDrawTest {
    @Test
    @DisplayName("로또 결과는 정상적으로 생성되어야 한다.")
    void 로또_결과_정상_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);

        LottoDraw lottoDraw = new LottoDraw(lotto, bonus);

        assertNotNull(lottoDraw);
        assertNotNull(lottoDraw.hashCode());
    }

    @Test
    @DisplayName("로또 숫자 비교는 정상적으로 작동되어야 한다.")
    void 로또_비교는_정상적으로_작동해야한다() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        lottoList.add(lotto);

        LottoDraw lottoDraw = new LottoDraw(lotto, bonus);

        Prizes prizes = lottoDraw.compare(lottoList);

        assertEquals(2000000000, prizes.sumProfit());
    }
}