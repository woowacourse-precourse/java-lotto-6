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

        announcePublishedLotto(cashier, lottoCompany);
        Lotto lotto = requestInputWinningNumbers();
        int bonusNumber = requestInputBonusNumber();

        lottoCompany.calculateReward(lotto.getNumbers(), bonusNumber);
        RewardHistory rewardHistory = lottoCompany.getRewardHistory();
        cashier.calculateTotalRewardAmount(rewardHistory);
        double profitRate = cashier.calculateProfitRate();
        announceFinalStatistics(rewardHistory, profitRate);
    }

    private void announcePublishedLotto(Cashier cashier, LottoCompany lottoCompany) {
        try {
            output.printMessage("구입금액을 입력해 주세요.\n");
            int purchaseAmount = input.inputPurchaseAmount();
            int calculateLottoCount = cashier.calculateLottoCount(purchaseAmount);
            output.printMessage(calculateLottoCount + "개를 구매했습니다.\n");
            LottoBundle lottoBundle = lottoCompany.publishNLotto(calculateLottoCount);
            List<Lotto> bundle = lottoBundle.getBundle();
            for (Lotto lotto : bundle) {
                output.printMessage(lotto.toString() + "\n");
            }
        } catch (Exception e) {
            output.printMessage(e.getMessage());
            announcePublishedLotto(cashier, lottoCompany);
        }
    }

    private Lotto requestInputWinningNumbers() {
        try {
            output.printMessage("당첨 번호를 입력해 주세요.\n");
            return input.inputWinningNumbers();
        } catch (Exception e) {
            output.printMessage(e.getMessage());
            return requestInputWinningNumbers();
        }

    }

    private int requestInputBonusNumber() {
        try {
            output.printMessage("보너스 번호를 입력해 주세요.\n");
            return input.inputBonusNumber();
        } catch (Exception e) {
            output.printMessage(e.getMessage());
            return requestInputBonusNumber();
        }
    }

    private void announceFinalStatistics(RewardHistory rewardHistory, double profitRate) {
        output.printMessage(rewardHistory.announceRewardStatistics());
        output.printMessage("총 수익률은 " + profitRate + "%입니다.\n");
    }
}
