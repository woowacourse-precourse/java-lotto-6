package lotto.service;

import java.util.List;
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

        // 몇개맞았는지 저장
        LotteryTracker lotteryTracker = new LotteryTracker();
        lotteryTracker.create();
        int cnt =0;
        List<List<Integer>> result = lotteryTracker.getResult();

        for (Lotto buyLotto : buyLottoRepo.getLottos()) {
            cnt = winningLottoRepo.countMatchingNumber(buyLotto);
            if(cnt==3){
                result.get(5).add(cnt);}
            else if(cnt==4){
                result.get(4).add(cnt);}
            else if(cnt==5){
                if(buyLotto.getNumbers().contains(bonusNumber.getNumber())){
                    result.get(2).add(cnt);
                }
                result.get(3).add(cnt);
            }
            else if(cnt==6){
                result.get(1).add(cnt);}
        }
        printResult(lotteryTracker);
    }

    private static void printResult(LotteryTracker lotteryTracker) {

        RankingRepository.create();

        //등수별 결과 출력
        for(int rank=5; rank>0;rank--){
            View.result(RankingRepository.getResultBy(rank), lotteryTracker.countLottoIn(rank));
        }
    }
}
