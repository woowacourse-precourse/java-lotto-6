package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.RankingRepository;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class ResultService {
    public static void play(BuyLottoRepository buyLottoRepo, WinningLottoRepository winningLottoRepo){
        View.winningStatistics();
        int bonusNum = winningLottoRepo.getBonusNumber();

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

    //총 수익률은 %.2f입니다
}
