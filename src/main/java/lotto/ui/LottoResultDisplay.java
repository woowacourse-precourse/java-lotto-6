package lotto.ui;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicketGenerator;

public class LottoResultDisplay {
    LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    public LottoResultDisplay() {
    }

    public void showWinningDetails(LottoResult lottoResult) {
        System.out.println("3개 일치 (5,000원) - " + lottoResult.fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.first + "개");
    }

    public void showProfitMargin(double profitMargin) {
        System.out.print("총 수익률은 " + profitMargin + "%입니다.");
    }

}
