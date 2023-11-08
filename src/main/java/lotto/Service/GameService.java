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

import static lotto.View.InputLottoUI.lottoCountView;

public class GameService {
    int money;
    int lottoCount;
    int bonusNumber;
    List<List<Integer>> lottos;
    List<Integer> answerNumbers;
    Referee referee;

    public void setGame() {
        while (true) {
            OutputLottoUI.inputMoneyView();
            money = InputLottoUI.inputMoneyPrint();
            try {
                lottoCount = LottoSalesman.lottoCount(money);
                lottoCountView(lottoCount);
                lottos = LottoSalesman.buyLotto(lottoCount);
                InputLottoUI.lottoSalse(lottos);
                break;
            } catch (IllegalArgumentException e) {
                OutputLottoUI.moneyViewReInput();
            }
        }

        while (true) {
            OutputLottoUI.answerLottoView();
            try {
                answerNumbers = InputLottoUI.inputAnswerLottoPrint();
                Lotto.validate(answerNumbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputLottoUI.answerViewReInput();
            }

        }

        while (true) {
            OutputLottoUI.answerBonusNumberView();
            try {
                bonusNumber = LottoSalesman.bonusValidate(bonusNumber);
                Lotto.bonusdupulicationCheck(answerNumbers, bonusNumber);
                referee = new Referee(answerNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputLottoUI.bonusViewReInput();
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
            Rank rank = Rank.matchingNumbersToRank(matchingNumbers, bonusNumberMatch);

            if (rank != Rank.NO_MATCH) {
                matchingCounts.put(rank, matchingCounts.get(rank) + 1);
            }
        }

        LottoSalesman.rankTotal(matchingCounts, totalPrize, money);
    }

}
