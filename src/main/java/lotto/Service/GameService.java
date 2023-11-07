package lotto.Service;

import lotto.Domain.LottoSalesman;
import lotto.Domain.Rank;
import lotto.Domain.Referee;
import lotto.View.InputLottoUI;
import lotto.View.OutputLottoUI;

import java.util.ArrayList;
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

                //TODO 들여쓰기 3번이라 추후에 메소드로 구현하기
                if (answerNumbers.size() != 6) {
                    System.out.println("Please enter exactly 6 numbers.");
                    continue;
                }

                OutputLottoUI.answerBonusNumberView();
                referee = new Referee(answerNumbers, InputLottoUI.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    } // setGame() END

    public void resultGame() {
        Map<Rank, Integer> matchingCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            matchingCounts.put(rank, 0);
        }

        int bonusNumberCount = 0; // 보너스 볼 일치 수

        for (List<Integer> playerLotto : lottos) {
            int matchingNumbers = referee.compare(playerLotto);
            boolean bonusNumberMatch = referee.getBonusNumber();

            if (bonusNumberMatch) {
                bonusNumberCount++;
            }

            Rank rank = matchingNumbersToRank(matchingNumbers, bonusNumberMatch);

            matchingCounts.put(rank, matchingCounts.get(rank) + 1);
        }

        for (Rank rank : matchingCounts.keySet()) {
            int count = matchingCounts.get(rank);
            String resultDescription = rank.getDescription();
            System.out.println(resultDescription + " - " + count + "개");
        }
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
