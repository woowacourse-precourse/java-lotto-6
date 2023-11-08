package lotto;

import static lotto.model.Rank.FIFTH;
import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.FOURTH;
import static lotto.model.Rank.NO_RANK_ONE;
import static lotto.model.Rank.NO_RANK_TWO;
import static lotto.model.Rank.NO_RANK_ZERO;
import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Answer;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Prize;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("당첨과 로또의 일치 정도 판단")
    void MakePrizeResultIfLottoAndAnswerInput() {
        Prize prize = getRankIntegerMap();
        Map<Rank, Integer> prizeRes = prize.getPrizeResult();

        assertAll(
                () -> assertEquals(prizeRes.get(NO_RANK_ZERO), 0),
                () -> assertEquals(prizeRes.get(NO_RANK_ONE), 0),
                () -> assertEquals(prizeRes.get(NO_RANK_TWO), 0),
                () -> assertEquals(prizeRes.get(FIFTH), 0),
                () -> assertEquals(prizeRes.get(FOURTH), 0),
                () -> assertEquals(prizeRes.get(THIRD), 1),
                () -> assertEquals(prizeRes.get(FIRST), 1),
                () -> assertEquals(prizeRes.get(SECOND), 0)
        );

    }

    private static Prize getRankIntegerMap() {
        final List<Integer> answerNum = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        Answer answer = new Answer(answerNum, bonus);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        LottoGame lottogame = new LottoGame(2000, lottos);
        Prize prize = new Prize();
        prize.initPrize();

        prize.compareAnswerAndLotto(answer, lottogame);
        return prize;
    }

    @Test
    @DisplayName("총 수익률 일치하는지 판단")
    void GetPrizeMoneyIfPrizeResultInput() {
        Prize prize = getRankIntegerMap();
        prize.calculateTotalPrizeMoney();
        prize.calculateProfit(2000);
        double profit = prize.getProfit();
        String result = String.format("%.1f", profit);

        assertEquals(result, "100075000.0");
    }

}
