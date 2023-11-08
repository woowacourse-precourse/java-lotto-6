package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Utils.InputSystem;
import lotto.Utils.SystemConstants;

public class Buyer {

    private int purchaseAmount;
    private final List<Lotto> lotteries = new ArrayList<>();

    public Buyer() {
    }

    public List<Lotto> getPurchasedLotteries() {
        return lotteries;
    }

    public void buyLotto(int purchaseMoney) throws IllegalArgumentException {
        try {
            purchaseAmount = purchaseMoney;
            exceptionDivide(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(SystemConstants.PURCHASE_MONEY_NOT_DIVIDED_1000);
            buyLotto(InputSystem.inputPurchaseMoney());
            return;
        }

        addLotteries(calculatePurchasingVolume());
    }

    private int calculatePurchasingVolume() {
        var purchasingVolume = purchaseAmount / SystemConstants.DIVIDED_NUMBER;
        System.out.printf((SystemConstants.PURCHASE_MESSAGE) + "%n", purchasingVolume);
        return purchasingVolume;
    }

    private void addLotteries(int purchasingVolume) {
        for (int i = 0; i < purchasingVolume; i++) {
            lotteries.add(createLotto());
        }
    }

    private static void exceptionDivide(int purchaseMoney) {
        if (purchaseMoney % SystemConstants.DIVIDED_NUMBER != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private Lotto createLotto() {
        return new Lotto(LottoNumbers.createSixLottoNumbers());
    }
}
