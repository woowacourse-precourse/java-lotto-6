package lotto.Service;

import lotto.Domain.Lotto;
import lotto.Domain.LottoSalesman;
import lotto.Domain.Rank;
import lotto.Domain.Referee;
import lotto.View.InputLottoUI;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.View.InputLottoUI.lottoCountView;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    int money = 8000;
    int lottoCount;
    List<List<Integer>> lottos;
    int bonusNumber = 9;
    Referee referee;
    List<Integer> answerNumbers = Arrays.asList(1,2,3,4,5,6);

    @Test
    public void setGame() {

        lottoCount = LottoSalesman.lottoCount(money);
        lottoCountView(lottoCount);
        lottos = LottoSalesman.buyLotto(lottoCount);
        InputLottoUI.lottoSalse(lottos);

        Lotto.validate(answerNumbers);

        referee = new Referee(answerNumbers, bonusNumber);
    }

    @Test
    public void resultGame() {
        Map<Rank, Integer> matchingCounts = new HashMap<>();
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            matchingCounts.put(rank, 0);
        }

        for (List<Integer> playerLotto : lottos) {
            int matchingNumbers = referee.compare(playerLotto);
            boolean bonusNumberMatch = referee.getBonusNumber();
            Rank rank = Rank.matchingNumbersToRank(matchingNumbers, bonusNumberMatch);

            if (rank != Rank.NO_MATCH) {
                matchingCounts.put(rank, matchingCounts.get(rank) + 1);
            }
        }

        LottoSalesman.rankTotal(matchingCounts, totalPrize, money);
    }

}