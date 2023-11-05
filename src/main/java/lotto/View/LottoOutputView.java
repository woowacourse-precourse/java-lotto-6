package lotto.View;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Model.Prize;

import java.text.NumberFormat;
import java.util.Map;

public class LottoOutputView {
    public void printPickedLotto(LottoContainer lottoContainer) {
        System.out.println();
        System.out.println(lottoContainer.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto :
                lottoContainer.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinnings(Map<String, Integer> winnings, int cash) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            Integer count = winnings.getOrDefault(prize.getRank(), 0);
            totalPrize += prize.getPrize() * count;
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            String formattedNumber = numberFormat.format(prize.getPrize());
            System.out.println(prize.getRank() + " (" + formattedNumber + "원) - " + count + "개");
        }

        double revenueRate = ((double) totalPrize / cash) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenueRate);
    }
}
