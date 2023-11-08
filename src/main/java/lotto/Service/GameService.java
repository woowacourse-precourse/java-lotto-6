package lotto.Service;

import lotto.Domain.Lotto;
import lotto.Domain.LottoSalesman;
import lotto.Domain.Rank;
import lotto.Domain.Referee;
import lotto.View.InputLottoUI;
import lotto.View.OutputLottoUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.View.OutputLottoUI.lottoCountView;

public class GameService {
    int money;
    int lottoCount;
    List<List<Integer>> lottos;
    Referee referee;

    public void setGame() {
        while (true) {
            OutputLottoUI.inputMoneyView();
            money = InputLottoUI.inputMoneyPrint();
            try {
                lottoCount = LottoSalesman.lottoCount(money);
                lottoCountView(lottoCount);
                lottos = LottoSalesman.buyLotto(lottoCount);
                OutputLottoUI.lottoSalse(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            OutputLottoUI.answerLottoView();
            try {
                List<Integer> answerNumbers = InputLottoUI.inputAnswerLottoPrint();
                Lotto.validate(answerNumbers);
                OutputLottoUI.answerBonusNumberView();
                referee = new Referee(answerNumbers, InputLottoUI.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputLottoUI.answerViewReInput();
            }

        }
    } // setGame() END

    public void resultGame() {
        Map<Rank, Integer> matchingCounts = new HashMap<>();
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            matchingCounts.put(rank, 0);
        }

        for (List<Integer> playerLotto : lottos) {
            int matchingNumbers = referee.compare(playerLotto);
            boolean bonusNumberMatch = referee.getBonusNumber();
            Rank rank = matchingNumbersToRank(matchingNumbers, bonusNumberMatch);

            if (rank != Rank.NO_MATCH) {
                matchingCounts.put(rank, matchingCounts.get(rank) + 1);
            }
        }

        LottoSalesman.rankTotal(matchingCounts, totalPrize, money);
    }

    private Rank matchingNumbersToRank(int matchingNumbers, boolean bonusNumberMatch) {
        if (matchingNumbers == 6) { return Rank.SIX_MATCH; }
        if (matchingNumbers == 5 && bonusNumberMatch) { return Rank.FIVE_MATCH_WITH_BONUS; }
        if (matchingNumbers == 5) { return Rank.FIVE_MATCH; }
        if (matchingNumbers == 4) { return Rank.FOUR_MATCH; }
        if (matchingNumbers == 3) { return Rank.THREE_MATCH; }
        return Rank.NO_MATCH;
    }
}
