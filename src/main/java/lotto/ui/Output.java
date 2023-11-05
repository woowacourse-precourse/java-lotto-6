package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public void notifyLottoCount(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.", lottoTickets.size());
    }

    public void notifyLottoNumbers(List<Integer> lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void notifyWinningDetails(List<Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5000원) - %d개\n", result.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(0));
    }

    public void notifyProfitRate(float rate) {
        System.out.printf("총 수익률은 %0.1f입니다.", rate);
    }
}
