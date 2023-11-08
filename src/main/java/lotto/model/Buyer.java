package lotto.model;

import java.util.List;
import lotto.view.OutputView;

public class Buyer {
    private final Money money;
    private final List<Lotto> lottos;

    public Buyer(Money inputMoney) {
        this.money = inputMoney;
        lottos = LottoStore.buyLotto(money);
        OutputView.printBuyLottoResultMessage(lottos);
    }

    public RewardResult guessLottery(WinningLotto winningLotto) {
        RewardResult rewardResult = new RewardResult();
        lottos.forEach(lotto -> rewardResult.addReward(lotto.getLottoResult(winningLotto)));

        return rewardResult;
    }

    public double getRateOfReturn(RewardResult rewardResult) {
        return money.calculateRateOfReturn(rewardResult.getTotalRewardMoney());
    }
}
