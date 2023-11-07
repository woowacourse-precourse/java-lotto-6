package lotto.domain;

import static lotto.constants.LottoRank.getRewardNamesAsArray;
import static lotto.constants.LottoRank.getRewardsAsArray;
import static lotto.domain.LottoProfit.getReturnRate;
import static lotto.domain.Lottos.generateLottos;

import java.util.List;

public class LottoGame {
    LottoResult lottoResult;
    InputChecker inputChecker;

    public LottoGame() {
        lottoResult = new LottoResult();
        inputChecker = new InputChecker();
    }

    public void start() {
        long userLottoPrice = inputChecker.readLottoPrice();
        long lottoCount = lottoResult.lottoNumbersPurchased(userLottoPrice);
        printLottoCountPurchased(lottoCount);

        Lottos purchasedLottos = generateLottos(lottoCount);

        processWinningNumbers(purchasedLottos);
        printResults(purchasedLottos);
    }

    private void processWinningNumbers(Lottos purchasedLottos) {
        List<Integer> winningNumbers = inputChecker.readWinningNumbers();
        Integer bonusNumber = inputChecker.readBonusNumber();
        purchasedLottos.printLottos();
        lottoResult.calculateRewardStatistics(purchasedLottos, winningNumbers, bonusNumber);
    }

    private void printResults(Lottos purchasedLottos) {
        printRewardStatistics();
        printReturnRate(purchasedLottos);
    }

    private void printLottoCountPurchased(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
    private void printReturnRate(Lottos purchasedLottos) {
        long totalReward = lottoResult.getTotalReward();
        double returnRate = getReturnRate(purchasedLottos.count(), totalReward);
        System.out.println("총 수익률은 " + String.format("%.1f%%", returnRate) + "입니다.");
    }
    private void printRewardStatistics(){
        String[] rewardNames = getRewardNamesAsArray();
        int[] reward = getRewardsAsArray();
        int [] rewardMatch = lottoResult.getRewardMatch();

        for (int i = 0; i < rewardMatch.length; i++) {
            System.out.println(rewardNames[i] + " 일치 (" + String.format("%,d원", reward[i]) + ") - " + rewardMatch[i] + "개");
        }
    }
}
