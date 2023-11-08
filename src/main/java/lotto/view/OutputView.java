package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;

import java.util.List;

public class OutputView {
    public void printNumberOfPurchase(int purchase) {
        System.out.println(purchase + "개를 구매했습니다.");
    }
    public void printLottoTicket(LottoTicket lottoTicket) {
        List<Lotto> lottoList = lottoTicket.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printPrize(LottoTicket lottoTicket) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        System.out.println("3개 일치 (5,000원) - " + lottoTicket.rank.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoTicket.rank.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoTicket.rank.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoTicket.rank.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoTicket.rank.get(1)+ "개");
    }

    public void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
