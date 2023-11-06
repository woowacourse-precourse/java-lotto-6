package lotto.domain;

import lotto.data.Lotto;
import lotto.data.Rewards;

import java.util.*;

public class OutputUI {

    public void rate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

    public void purchaseLog(int num, List<Lotto> publishedLottos) {
        System.out.println();
        System.out.println(num + "개를 구매했습니다.");
        for (Lotto lotto : publishedLottos) {
            System.out.println(lotto.getNumbers());
        }

    }

    public void winnings(HashMap<Rewards, Integer> resultAll) {
        Rewards[] rewards = Rewards.values();
        Arrays.sort(rewards, Comparator.comparingInt(Rewards::correctLottos));
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rewards reward : rewards) {
            System.out.printf("%s %s - %d개\n", reward.getNotifyMessege(), moneyEdit(reward)
                    , resultAll.get(reward));
        }
    }

    public String moneyEdit(Rewards reward) {
        int money = reward.money();
        String beforeEdit = Integer.toString(money);
        String reversedEdit = new StringBuilder(beforeEdit).reverse().toString();
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < reversedEdit.length(); i++) {
            if (i > 0 && i % 3 == 0) {
                formatted.append(",");
            }
            formatted.append(reversedEdit.charAt(i));
        }
        String result = "(" + formatted.reverse().toString() + "원)";
        return result;
    }


}
