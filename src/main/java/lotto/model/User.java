package lotto.model;

import lotto.utils.Util;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Amount purchaseAmount;
    private List<Lotto> purchasedLottos;

    private User(Amount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static User from(int purchaseAmount) {
        return new User(Amount.from(purchaseAmount));
    }

    public void purchaseLottos() {
        purchasedLottos = new ArrayList<>();
        int lottoCount = purchaseAmount.getLottoCount();
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = generateLottoNumber();
            purchasedLottos.add(lotto);
        }
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = Util.generateRandomNumber();
        return Lotto.from(numbers);
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
