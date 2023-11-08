package lotto;

import lotto.domain.*;
import java.util.List;

public class LottoManager {
    private final CreateLotto createLotto;
    private final WinReward winReward;
    private final ProfitRate profitRate;

    public LottoManager(CreateLotto createLotto, WinReward winReward, ProfitRate profitRate) {
        this.createLotto = new CreateLotto();
        this.winReward = new WinReward();
        this.profitRate = new ProfitRate();
    }

    public void startGame(PurchaseAmount purchaseAmount, WinReward winReward) {
        List<Lotto> lottos = createLotto.create(purchaseAmount);
        for (Lotto lotto : lottos) {
            Rank rank = winReward.match(lotto);
            winReward.addRank(rank);
        }
        double profitRate = this.profitRate.calculate(winReward.getTotalReward(), purchaseAmount.getAmount());
        printResults(profitRate);
    }

    private void printResults(double profitRate) {
        System.out.println(winReward);
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }
}