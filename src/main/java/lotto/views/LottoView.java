package lotto.views;

import lotto.model.LotteryPrize;

import java.util.List;

public class LottoView {
    public void lottoTicketCountView(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void showWinningStatistics(List<LotteryPrize> prizes){
        for (LotteryPrize prize : prizes) {
            System.out.println(prize);
        }
    }

    public void showRateOfReturn(double rateOfReturn){
        System.out.println("총 수익률은 " + String.format("%.1f%%입니다.", rateOfReturn));
    }
}
