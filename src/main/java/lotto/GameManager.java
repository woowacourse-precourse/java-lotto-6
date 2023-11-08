package lotto;

import java.util.List;
import lotto.cashier.Cashier;
import lotto.lottocompany.Lotto;
import lotto.lottocompany.LottoBundle;
import lotto.lottocompany.LottoCompany;
import lotto.lottocompany.RewardHistory;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class GameManager {

    private final Input input;
    private final Output output;

    public GameManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        Cashier cashier = new Cashier();
        LottoCompany lottoCompany = new LottoCompany();

        int purchaseAmount = requestPurchaseAmountInput();
        announcePublishedLotto(cashier, purchaseAmount, lottoCompany);
        Lotto lotto = requestInputWinningNumbers();
        int bonusNumber = requestInputBonusNumber();

        lottoCompany.calculateReward(lotto.getNumbers(), bonusNumber);
        RewardHistory rewardHistory = lottoCompany.getRewardHistory();
        cashier.calculateTotalRewardAmount(rewardHistory);
        double profitRate = cashier.calculateProfitRate();
        announceFinalStatistics(rewardHistory, profitRate);
    }

    private int requestPurchaseAmountInput() {
        output.printMessage("구입금액을 입력해 주세요.\n");
        return input.inputPurchaseAmount();
    }

    private void announcePublishedLotto(Cashier cashier, int purchaseAmount, LottoCompany lottoCompany) {
        int calculateLottoCount = cashier.calculateLottoCount(purchaseAmount);
        output.printMessage(calculateLottoCount + "개를 구매했습니다.\n");
        LottoBundle lottoBundle = lottoCompany.publishNLotto(calculateLottoCount);
        List<Lotto> bundle = lottoBundle.getBundle();
        for (Lotto lotto : bundle) {
            output.printMessage(lotto.toString() + "\n");
        }
    }

    private Lotto requestInputWinningNumbers() {
        output.printMessage("당첨 번호를 입력해 주세요.\n");
        return input.inputWinningNumbers();
    }

    private int requestInputBonusNumber() {
        output.printMessage("보너스 번호를 입력해 주세요.\n");
        return input.inputBonusNumber();
    }

    private void announceFinalStatistics(RewardHistory rewardHistory, double profitRate) {
        output.printMessage(rewardHistory.announceRewardStatistics());
        output.printMessage("총 수익률은 " + profitRate + "%입니다.\n");
    }
}
