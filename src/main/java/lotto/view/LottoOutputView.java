package lotto.view;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class LottoOutputView {
    private static final String MONEY_FORMAT = "###,###원";
    private static final int SIX_MATCH_PRIZE = 2000000000;
    private static final int FIVE_WITH_BONUS_MATCH_PRIZE = 30000000;
    private static final int FIVE_MATCH_PRIZE = 1500000;
    private static final int FOUR_MATCH_PRIZE = 50000;
    private static final int THREE_MATCH_PRIZE = 5000;

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

    public void printLottoResult(Map<LottoRank, Integer> result) {
        DecimalFormat prizeFormat = new DecimalFormat(MONEY_FORMAT);
        LottoRank[] ranks = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : ranks) {
            System.out.printf("%s (%s) - %d개\n", rank.getDescription(), prizeFormat.format(rank.getPrize()), result.get(rank));
        }
    }

    public void printProfit(int before, int after) {
        double profit = (double) (after - before) / before * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
