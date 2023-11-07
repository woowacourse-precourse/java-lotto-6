package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.Lotto;
import lotto.data.Rewards;
import lotto.domain.ViewProcessor;

import java.util.*;

public class UserView {
    private static final ViewProcessor viewProcessor = new ViewProcessor();
    private final boolean STATE_SUCESS = false;
    private final boolean STATE_FAILDURE = true;
    private final boolean STATE_INIT = true;

    public void purchase() {
        boolean state = STATE_INIT;
        while (state == STATE_SUCESS) {
            System.out.println("구입금액을 입력해 주세요.");
            String tempCost = Console.readLine();
            state = viewProcessor.purchase(tempCost);
        }
    }

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

    public void winnings() {
        boolean state = STATE_INIT;
        while (state == STATE_SUCESS) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputWinnings = Console.readLine();
            state = viewProcessor.winnings(inputWinnings);
        }
    }

    public void winningsLog(HashMap<Rewards, Integer> resultAll) {
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
