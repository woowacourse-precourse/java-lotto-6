package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Reward;
import lotto.dto.GameResultResponse;
import lotto.dto.LottosResponse;
import lotto.message.GameMessage;

public class OutputView {
    public void printBuyMessage(int count){
        System.out.println("\n" + count + GameMessage.BUY_MESSAGE);
    }
    public void printLottos(LottosResponse response){
        for (Lotto lotto: response.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
    public void printResult(GameResultResponse response){
        System.out.println("\n" + GameMessage.RESULT_MESSAGE);
        Map<Integer, Integer> reward = response.getTotalReward();
        System.out.println(GameMessage.FIFTH_REWARD + reward.get(5) + GameMessage.COUNT);
        System.out.println(GameMessage.FOURTH_REWARD + reward.get(4) + GameMessage.COUNT);
        System.out.println(GameMessage.THIRD_REWARD + reward.get(3) + GameMessage.COUNT);
        System.out.println(GameMessage.SECOND_REWARD + reward.get(2) + GameMessage.COUNT);
        System.out.println(GameMessage.FIRST_REWARD + reward.get(1) + GameMessage.COUNT);
        System.out.printf(GameMessage.PROFIT_MESSAGE, response.getProfit());
    }
}
