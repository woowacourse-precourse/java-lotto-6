package lotto.domain;

import static lotto.constants.LottoRank.getRewardNamesAsArray;
import static lotto.constants.LottoRank.getRewardsAsArray;
import static lotto.domain.LottoProfit.getReturnRate;
import static lotto.domain.Lottos.generateLottos;

import java.util.List;
import lotto.constants.LottoRank;

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

        // 로또(들) 생성
        Lottos purchasedLottos = generateLottos(lottoCount);

        // 당첨,보너스 번호 입력
        List<Integer> winningNumbers = inputChecker.readWinningNumbers();
        Integer bonusNumber = inputChecker.readBonusNumber();

        purchasedLottos.printLottos(); // 로또 번호 모두 출력

        // 결과 통계 계산
        lottoResult.calculateRewardStatistics(purchasedLottos,winningNumbers,bonusNumber);

        // 수익률 출력
        printReturnRate(purchasedLottos);
        printRewardStatistics();
    }

    private void printLottoCountPurchased(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }
    private void printReturnRate(Lottos purchasedLottos) {
        long totalReward = lottoResult.getTotalReward();
        double returnRate = getReturnRate(purchasedLottos.count(), totalReward);
        System.out.println("총 수익률은 " + String.format("%.1f%%", returnRate * 100) + "입니다.");
    }
    private void printRewardStatistics(){
        String[] rewardNames = getRewardNamesAsArray();//lottoResult.getRewardNames();
        int[] reward = getRewardsAsArray(); //lottoResult.getReward();
        int [] rewardMatch = lottoResult.getRewardMatch();

        for (int i = 0; i < rewardMatch.length; i++) {
            System.out.println(rewardNames[i] + " 일치 (" + String.format("%,d원", reward[i]) + ") - " + rewardMatch[i] + "개");
        }
    }
}
