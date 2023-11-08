package lotto.service;

import lotto.domain.Result;
import lotto.enumeration.WinningType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ResultService {

    public BigDecimal calcProfitRate(Result result, int amount) {
        int totalPrize = getTotalPrize(result);
        double profit = ((double) totalPrize / amount) * 100;

        return new BigDecimal(profit).setScale(1, RoundingMode.HALF_UP);
    }

    public int getTotalPrize(Result result) {
        int totalPrize = 0;
        for (WinningType winningType : WinningType.values()) {
            totalPrize += result.getResult().get(winningType) * winningType.getPrize();
        }
        return totalPrize;
    }

    public void printWinningStat(Result result) {
        for (WinningType winningType : WinningType.values()) {
            if (winningType == WinningType.MISS) {
                continue;
            }
            int matchedCount = winningType.getMatchedCount();
            String prize = formatWithComma(winningType.getPrize());
            int count = result.getResult().get(winningType);

            if (winningType == WinningType.SECOND) {
                System.out.println(matchedCount + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개");
                continue;
            }
            System.out.println(matchedCount + "개 일치 (" + prize + "원) - " + count + "개");
        }
    }

    private String formatWithComma(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }
}
