package lotto.model;

import java.util.List;
import lotto.view.ErrorMessage;
import lotto.view.OutputView;
import lotto.User;

public class Cashier {

    LottoMachine lottoMachine = new LottoMachine();

    public List<Lotto> takeOrder(int purchaseAmount) {
        if (validate(purchaseAmount) == -1) {
            return null;
        }
        return lottoMachine.createLottos(calculateLottoCountBy(purchaseAmount));
    }

    private int calculateLottoCountBy(int purchaseAmount) {
        return User.purchaseCount = purchaseAmount / LottoNumbers.PURCHASE_AMOUNT_UNIT;
    }

    public int validate(int purchaseAmount) {
        try {
            checkZero(purchaseAmount);
            checkUnit(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return -1;
        }
    }

    public static void checkZero(int purchaseAmount) {
        if (purchaseAmount < LottoNumbers.PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO);
        }
    }

    public static void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LottoNumbers.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT);
        }
    }
}
