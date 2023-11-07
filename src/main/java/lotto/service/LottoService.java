package lotto.service;

public class LottoService {

    private LottoService() {
    }

    public static String formatPercentage(int money, double profit) {
        double roundedProfit = profit / money * 100.0;
        return String.format("%,.1f%%", roundedProfit);
    }
}
