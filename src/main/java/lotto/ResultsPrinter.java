package lotto;

public class ResultsPrinter {
    private final LottoResult lottoResult;

    public ResultsPrinter(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                int count = lottoResult.getCountForPrize(prize);
                String resultMessage = getResultMessage(prize, count);
                System.out.println(resultMessage);
            }
        }
    }

    private String getResultMessage(Prize prize, int count) {
        if (prize == Prize.SECOND) {
            return String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개",
                    formatCurrency(prize.getReward()), count);
        } else {
            return String.format("%d개 일치 (%s원) - %d개",
                    prize.getMatchCount(),
                    formatCurrency(prize.getReward()), count);
        }
    }

    public void printProfitRate(Money purchaseAmount) {
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }
}
