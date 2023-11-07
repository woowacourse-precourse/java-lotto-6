package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;

import java.util.List;

public class OutputView {

    public void printLottoAmount(int num) {
        System.out.printf("%d개를 구매했습니다.%n", num);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoRankingResult(Referee referee) {
        List<Integer> lottoRank = referee.getLottoRank();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoRank.get(5));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoRank.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoRank.get(3));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoRank.get(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoRank.get(1));
    }

    public void printLottoBenefitResult(Referee referee) {
        System.out.printf("총 수익률은 %.1f%s입니다.\n", referee.getLottoBenefit(), "%");
    }
}
