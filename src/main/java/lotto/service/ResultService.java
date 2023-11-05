package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.RankingRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
//    3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
//    총 수익률은 62.5%입니다.
    public static void play(BuyLottoRepository buyLottoRepo, WinningLottoRepository winningLottoRepo){
        View.winningStatistics();
        BonusNumber bonusNumber = winningLottoRepo.getBonusNumber();
        int bonusNum = bonusNumber.getNumber();

        // 몇개맞았는지 저장
        LotteryTracker lotteryTracker = new LotteryTracker();
        lotteryTracker.create();

        int cnt =0;
        for (Lotto buyLotto : buyLottoRepo.getLottos()) {
            cnt = winningLottoRepo.countMatchingNumber(buyLotto);
            lotteryTracker.matchingNumber(cnt,buyLotto,bonusNum);
        }
        lotteryTracker.printResult();
    }
}
