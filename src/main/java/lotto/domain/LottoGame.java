package lotto.domain;

import static lotto.domain.InputChecker.readLottoPrice;
import static lotto.domain.LottoProfit.getReturnRate;
import static lotto.domain.Lottos.generateLottos;

import camp.nextstep.edu.missionutils.Console;
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
        System.out.println(lottoCount + "개를 구매했습니다.");

        // 로또(들) 생성
        Lottos purchasedLottos = generateLottos(lottoCount);

        // 당첨,보너스 번호 입력
        List<Integer> winningNumbers = inputChecker.readWinningNumbers();
        Integer bonusNumber = inputChecker.readBonusNumber();

        // 통계 출력
        lottoResult.printRewardStatistics(purchasedLottos,winningNumbers,bonusNumber);

        // 수익률 계산
        long totalReward = lottoResult.getTotalReward();
        double returnRate = getReturnRate(purchasedLottos.count(),totalReward);
        System.out.println("총 수익률은 " + String.format("%.1f%%", returnRate * 100) + "입니다.");
    }

}
