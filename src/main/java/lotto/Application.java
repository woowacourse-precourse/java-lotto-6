package lotto;

import java.util.List;

public class Application {
    public static final int LOTTO_PRICE = 1000;
    private static final PrintOut printOut = new PrintOut();
    private static final LottoResult lottoResult = new LottoResult();
    private static final LottoFactory lottoFactory = new LottoFactory();

    public static void main(String[] args) {
        int userPurchaseAmount = lottoFactory.getUserPurchaseAmount();
        int numberOfLottos = lottoFactory.calculateNumberOfLottos(userPurchaseAmount);

        List<Lotto> purchasedLottos = lottoFactory.getPurchasedLottos(numberOfLottos);

        Lotto winningNumber = lottoFactory.getWinningLotto();
        int bonusNumber = lottoFactory.getBonusNumber(winningNumber);

        lottoFactory.calculateResults(purchasedLottos, winningNumber, bonusNumber, lottoResult);
        double roundedReturn = lottoResult.getRoundedReturn(userPurchaseAmount);

        printOut.getStatistics(lottoResult, roundedReturn);
    }
}
