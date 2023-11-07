package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static final int LOTTO_PRICE = 1000;
    private static final PrintOut printOut = new PrintOut();
    private static final InputHandler inputHandler = new InputHandler();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static final Validation validation = new Validation();

    public int getUserPurchaseAmount() {
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

    public int calculateNumberOfLottos(int userPurchaseAmount) {
        return userPurchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> getPurchasedLottos(int numberOfLottos) {
        printOut.confirmPurchase(numberOfLottos);
        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(numberOfLottos);
        return purchasedLottos;
    }

    public Lotto getWinningLotto() {
        boolean validInputNumber = false;
        List<Integer> winningNumber = new ArrayList<>();
        Lotto lotto = null;
        printOut.inputWinningNumber();
        while (!validInputNumber) {
            try {
                winningNumber = inputHandler.getWinningNumber();
                lotto = new Lotto(winningNumber);
                validInputNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    public int getBonusNumber(Lotto winningLotto) {
        printOut.inputBonusNumber();
        int bonusNumber = 0;
        boolean validInputNumber = false;
        while (!validInputNumber) {
            try {
                bonusNumber = inputHandler.getInputNumber();
                validation.bonusNumberCheck(winningLotto, bonusNumber);
                validation.numberRange(bonusNumber);
                validInputNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public void calculateResults(
            List<Lotto> purchasedLottos,
            Lotto winningLotto,
            int bonusNumber,
            LottoResult lottoResult
    ) {
        for (Lotto purchasedLotto : purchasedLottos) {
            WinningCriteria criteria = lottoResult.getWinningCriteria(purchasedLotto, winningLotto, bonusNumber);
            if (criteria != null) {
                lottoResult.addWin(criteria);
            }
        }
    }
}
