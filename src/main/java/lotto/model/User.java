package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constants;
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

    public List<Lotto> purchaseLottos() {
        purchasedLottos = new ArrayList<>();
        int lottoCount = purchaseAmount.getLottoCount();
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = generateLottoNumber();
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, 6);
        return new Lotto(numbers);
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
