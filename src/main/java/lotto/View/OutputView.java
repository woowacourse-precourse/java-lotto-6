package lotto.View;

import static lotto.Constants.BudgetConstants.BUDGET_UNIT;
import static lotto.Constants.TurnOuts.TURN_OUT_RATE;
import static lotto.Message.OutputPrompt.HOW_MANY_LOTTERY_ARE_BOUGHT;
import static lotto.Message.OutputPrompt.LOTTO_GAME_RESULT_NOTICE;

import java.util.List;
import java.util.Map;
import lotto.Constants.MatchTypes;
import lotto.Model.Lotto;

public class OutputView {

    public void printHowManyLotteryBought(Integer lotteryBudget) {
        Integer numOfLottery = lotteryBudget / BUDGET_UNIT.getPrice();
        System.out.println(String.format(HOW_MANY_LOTTERY_ARE_BOUGHT.getMessage(), numOfLottery));
    }

    public void printRegisteredLottery(List<Lotto> lottoGroup) {
        for (Lotto lotto : lottoGroup) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public void printGameResult(Map<MatchTypes, Integer> gameResult) {
        System.out.println(LOTTO_GAME_RESULT_NOTICE.getMessage());
        printLottoResult(gameResult);
    }

    public void printLottoResult(Map<MatchTypes, Integer> gameResult) {
        for (MatchTypes matchType : gameResult.keySet()) {
            System.out.print(String.format(matchType.getMessage(), gameResult.get(matchType)));
        }
    }

    public void printTurnOutRate(Double turnOutRate) {
        System.out.print(String.format(TURN_OUT_RATE.getMessage(), turnOutRate));
    }
}
