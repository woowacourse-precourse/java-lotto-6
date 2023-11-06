package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int LOTTO_PRICE = 1000;
    private static final PrintOut printOut = new PrintOut();
    private static final InputHandler inputHandler = new InputHandler();
    private static final LottoResult lottoResult = new LottoResult();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static final Validation validation = new Validation();

    public static void main(String[] args) {
        int userPurchaseAmount = getUserPurchaseAmount();
        int numberOfLottos = calculateNumberOfLottos(userPurchaseAmount);
        List<Lotto> purchasedLottos = getPurchasedLottos(numberOfLottos);
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
        calculateResults(purchasedLottos, winningNumber, bonusNumber);
        double roundedReturn = lottoResult.getRoundedReturn(userPurchaseAmount, lottoResult);

        printOut.getStatistics(lottoResult, roundedReturn);
    }

    private static int getUserPurchaseAmount() {
        printOut.purchaseGuide();
        boolean validPurchaseAmount = false;
        int userPurchaseAmount = 0;
        while (!validPurchaseAmount) {
            try {
                userPurchaseAmount = inputHandler.getInputNumber();
                validation.price(userPurchaseAmount);
                validPurchaseAmount = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userPurchaseAmount;
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
        boolean validInputNumber = false;
        List<Integer> winningNumber = new ArrayList<>();
        while (!validInputNumber) {
            try {
                winningNumber = inputHandler.getWinningNumber();
                validation.duplicates(winningNumber);
                validInputNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    private static int getBonusNumber(List<Integer> winningNumber) {
        printOut.inputBonusNumber();
        int bonusNumber = 0;
        boolean validInputNumber = false;
        while (!validInputNumber) {
            try {
                bonusNumber = inputHandler.getInputNumber();
                validation.bonusNumberCheck(winningNumber, bonusNumber);
                validInputNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
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
