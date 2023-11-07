package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.constant.Constant;
import lotto.validation.InputException;
import lotto.view.Input;

public class Purchase {
    private final int amount;
    private final List<Lotto> purchasedLotto;

    public Purchase(String amount) {
        this.amount = initializeAmount(amount);
        this.purchasedLotto = initializePurchasedLotto();
    }

    private int initializeAmount(String amount) {

        try {
            validate(amount);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return initializeAmount(Input.amount());
        }

        return Integer.parseInt(amount) / 1000;
    }

    private List<Lotto> initializePurchasedLotto() {
        List<Lotto> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < this.amount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLotto.add(lotto);
        }

        return purchasedLotto;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }

    public final void printPurchasedLotto() {
        System.out.println("\n" + this.getAmount() + Constant.purchaseCount);

        for (Lotto lotto : this.purchasedLotto) {
            lotto.printLottoNumber();
        }
    }

    private void validate(final String amount) {
        InputException.blankInput(amount);
        InputException.notNumber(amount);
        InputException.underThousand(amount);
        InputException.notMultipleOfThousand(amount);
    }
}