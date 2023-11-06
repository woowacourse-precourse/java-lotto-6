package lotto.service;

import lotto.domain.Lotto;
import lotto.repository.rank.AmountsPerRank;
import lotto.repository.BuyLottoRepository;
import lotto.repository.rank.LottoNumbersPerRank;
import lotto.repository.rank.PrizesPerRank;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class LotteryTracker {

    private LotteryTracker() {
    }

    public static LotteryTracker create(){
        PrizesPerRank.create();
        AmountsPerRank.create();
        LottoNumbersPerRank.create();
        return new LotteryTracker();
    }

    public int countLottoIn(int rank){
        return LottoNumbersPerRank.getNumberBy(rank);
    }

    public void matching(BuyLottoRepository buyLottos, WinningLottoRepository winningLotto) {
        int correctNum =0;
        int bonusNum = winningLotto.getBonusNumber();

        for (Lotto buyLotto : buyLottos.getLotto()) {
            correctNum = winningLotto.countMatchingNumber(buyLotto);
            increaseNumberPerRank(correctNum,buyLotto,bonusNum);
        }
    }
    public void increaseNumberPerRank(int cnt, Lotto buyLotto, int bonusNum){
        int rank = buyLotto.findRank(cnt, bonusNum);
        LottoNumbersPerRank.plus(rank);
    }

    public void printResult() {
        //등수별 결과 출력
        for(int rank=5; rank>0;rank--){
            String prize = PrizesPerRank.getPrizeBy(rank);
            View.result(prize, countLottoIn(rank));
        }
    }

    public double calculateTotalRevenue() {
        int totalRevenue =0;
        for(int rank=5; rank>0;rank--){
            totalRevenue += LottoNumbersPerRank.getNumberBy(rank) * AmountsPerRank.getAmountBy(rank);
        }
        return totalRevenue;
    }
}
