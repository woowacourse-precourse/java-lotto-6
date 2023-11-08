package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    private static void startLotto() {
        User user = new User();
        Global global = new Global();

        int lottoPurchaseMoney = user.purchaseLotto();
        issueLottos(global, lottoPurchaseMoney);
        List<Integer> winningNumbersAndBonus = user.getWinningNumbersAndBonus();
        getLottoRanking(global, winningNumbersAndBonus);
        getRateOfReturn(global, lottoPurchaseMoney);
    }

    private static void issueLottos(Global global, int lottoPurchaseMoney) {
        int lottoCount = global.getLottoCount(lottoPurchaseMoney);
        global.getIssuedLottos(lottoCount);
        global.printIssuedLottoCountAndNumbers();
    }

    private static void getLottoRanking(Global global, List<Integer> winningLotto) {
        global.calculateRanking(winningLotto);
        global.printRanking();
    }

    private static void getRateOfReturn(Global global, int lottoPurchaseMoney) {
        double rateOfReturn = global.calculateRateOfReturn(lottoPurchaseMoney);
        global.printRateOfReturn(rateOfReturn);
    }
}
