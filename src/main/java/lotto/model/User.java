package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constants;
import lotto.utils.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int amount;
    private List<Lotto> purchasedLottos;

    private User(int amount) {
        this.amount = amount;
    }

    public static User from(int amount) {
        validateAmountUnit(amount);
        validateIsZero(amount);
        return new User(amount);
    }

    private static void validateAmountUnit(int amount) {
        if (amount % Constants.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_UNIT.getMessage());
        }
    }

    private static void validateIsZero(int amount) {
        if (amount == Constants.NO_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NO_AMOUNT.getMessage());
        }
    }

    public List<Lotto> purchaseLottos() {
        purchasedLottos = new ArrayList<>();
        int lottoCount = getLottoCount();
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = generateLottoNumber();
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private int getLottoCount() {
        return amount / Constants.LOTTO_PRICE;
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, 6);
        return new Lotto(numbers);
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
