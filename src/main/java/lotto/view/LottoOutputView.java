package lotto.view;

import lotto.constant.LottoRanking;
import lotto.domain.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class LottoOutputView {
    private static final String MONEY_FORMAT = "###,###원";

    public void printBuyingPriceInputRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBoughtResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printAnswerInputRequest() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusInputRequest() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoResult(Map<LottoRanking, Integer> result) {
        DecimalFormat prizeFormat = new DecimalFormat(MONEY_FORMAT);
        LottoRanking[] ranks = {LottoRanking.FIFTH, LottoRanking.FOURTH, LottoRanking.THIRD, LottoRanking.SECOND, LottoRanking.FIRST};

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRanking rank : ranks) {
            System.out.printf("%s (%s) - %d개\n",
                    rank.getDescription(),
                    prizeFormat.format(rank.getPrize()),
                    result.getOrDefault(rank, 0)
            );
        }
    }

    public void printProfit(int before, int after) {
        double profit = (double) after / before * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
