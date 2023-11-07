package lotto.UI;

import lotto.data.Lotto;
import lotto.data.Rewards;
import lotto.domain.ViewProcessor;

import java.util.*;

public class UserView {
    private final ViewProcessor viewProcessor = new ViewProcessor();


    public void purchaseLog(int num, List<Lotto> publishedLottos) {
        System.out.println();
        System.out.println(num + "개를 구매했습니다.");
        for (Lotto lotto : publishedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void rate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

    public void winnings(HashMap<Rewards, Integer> resultAll) {
        Rewards[] rewards = Rewards.values();
        Arrays.sort(rewards, Comparator.comparingInt(Rewards::correctLottos));
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rewards reward : rewards) {
            System.out.printf("%s %s - %d개\n", reward.getNotifyMessege(), viewProcessor.moneyEdit(reward)
                    , resultAll.get(reward));
        }
    }

}
