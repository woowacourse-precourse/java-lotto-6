package lotto.view;

import java.util.EnumMap;
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
        EnumMap<Reward, Integer> rewards = response.getRewards();
        System.out.println(GameMessage.FIFTH_REWARD + rewards.get(Reward.FIFTH_REWARD) + GameMessage.COUNT);
        System.out.println(GameMessage.FOURTH_REWARD + rewards.get(Reward.FOURTH_REWARD) + GameMessage.COUNT);
        System.out.println(GameMessage.THIRD_REWARD + rewards.get(Reward.THIRD_REWARD) + GameMessage.COUNT);
        System.out.println(GameMessage.SECOND_REWARD + rewards.get(Reward.SECOND_REWARD) + GameMessage.COUNT);
        System.out.println(GameMessage.FIRST_REWARD + rewards.get(Reward.FIRST_REWARD) + GameMessage.COUNT);
        System.out.printf(GameMessage.PROFIT_MESSAGE, response.getProfit());
    }
}
