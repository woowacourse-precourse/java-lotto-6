package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Model.Lotto;
import lotto.Constants.MatchTypes;

import static lotto.Message.OutputPrompt.WHITE_SPACE;
import static lotto.Message.OutputPrompt.HOW_MANY_LOTTERY_ARE_BOUGHT;
import static lotto.Message.OutputPrompt.LOTTO_GAME_RESULT_NOTICE;
import static lotto.Constants.TurnOuts.TURN_OUT_RATE;

public class OutputView {

    public void printHowManyLotteryBought(Integer numOfLottery){
        System.out.println(String.format(HOW_MANY_LOTTERY_ARE_BOUGHT.getMessage(), numOfLottery));
    }

    public void printRegisteredLottery(List<Lotto> lottoGroup){
        for(Lotto lotto : lottoGroup){
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public void printWholeResult(Map<MatchTypes, Integer> gameResult, Integer turnOutRate){
        System.out.println(WHITE_SPACE.getMessage());
        System.out.println(LOTTO_GAME_RESULT_NOTICE.getMessage());
        printLottoResult(gameResult);
        printTurnOutRate(turnOutRate);
    }
    public void printLottoResult(Map<MatchTypes, Integer> gameResult){
        for (MatchTypes matchType : gameResult.keySet()) {
            System.out.println(String.format(matchType.getMessage(), gameResult.get(matchType)));
        }
    }
    public void printTurnOutRate(Integer turnOutRate){
        System.out.println(String.format(TURN_OUT_RATE.getMessage(), turnOutRate));
    }
}
