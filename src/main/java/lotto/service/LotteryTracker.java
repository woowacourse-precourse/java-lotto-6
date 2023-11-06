package lotto.service;

import lotto.domain.Lotto;
import lotto.repository.rank.PrizesPerRank;
import lotto.repository.BuyLottoRepository;
import lotto.repository.rank.LottoNumbersPerRank;
import lotto.repository.rank.PrintsPerRank;
import lotto.repository.WinningLottoRepository;
import lotto.view.View;

public class LotteryTracker {

    private LotteryTracker() {
    }

    public static LotteryTracker create(){
        //등수별 출력결과 저장하는 곳
        PrintsPerRank.create();
        //등수별 상금 저장하는 곳
        PrizesPerRank.create();
        //등수별 로또수를 저장하는 곳
        LottoNumbersPerRank.create();
        return new LotteryTracker();
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
    public void printResultByRank() {
        //등수별 결과 출력
        for(int rank=5; rank>0;rank--){
            String prize = printBy(rank);
            View.result(prize, numberBy(rank));
        }
    }

    public double calculateTotalRevenue() {
        int totalRevenue =0;
        for(int rank=5; rank>0;rank--){
            totalRevenue += numberBy(rank) * prizeBy(rank);
        }
        return totalRevenue;
    }

    public int numberBy(int rank){
        return LottoNumbersPerRank.getNumberBy(rank);
    }
    public String printBy(int rank){
        return PrintsPerRank.getPrintBy(rank);
    }
    public int prizeBy(int rank){
        return PrizesPerRank.getPrizeBy(rank);
    }
}
