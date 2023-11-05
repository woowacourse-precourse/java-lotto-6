package lotto;

import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final PrintOut printOut = new PrintOut();
    private static final InputHandler inputHandler = new InputHandler();
    private static final LottoResult lottoResult = new LottoResult();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    public static void main(String[] args) {
        int userPurchaseAmount = getUserPurchaseAmount();
        int numberOfLottos = calculateNumberOfLottos(userPurchaseAmount);
        List<Lotto> purchasedLottos = getPurchasedLottos(numberOfLottos);
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        calculateResults(purchasedLottos, winningNumber, bonusNumber);
        double roundedReturn = lottoResult.getRoundedReturn(userPurchaseAmount, lottoResult);

        printOut.getStatistics(lottoResult, roundedReturn);
    }

    private static int getUserPurchaseAmount() {
        printOut.purchaseGuide();
        return inputHandler.getInputNumber();
    }

    private static int calculateNumberOfLottos(int userPurchaseAmount) {
        return userPurchaseAmount / LOTTO_PRICE;
    }

    private static List<Lotto> getPurchasedLottos(int numberOfLottos) {
        printOut.confirmPurchase(numberOfLottos);
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(numberOfLottos);
        return purchasedLottos;
    }
    
    private static List<Integer> getWinningNumber() {
        printOut.inputWinningNumber();
        return inputHandler.getWinningNumber();
    }

    private static int getBonusNumber() {
        printOut.inputBonusNumber();
        return inputHandler.getInputNumber();
    }

    private static void calculateResults(List<Lotto> purchasedLottos, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto purchasedLotto : purchasedLottos) {
            WinningCriteria criteria = lottoResult.getWinningCriteria(purchasedLotto, winningNumber, bonusNumber);
            if (criteria != null) {
                lottoResult.addWin(criteria);
            }
        }
    }
}
