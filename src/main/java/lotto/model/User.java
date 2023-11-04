package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int AMOUNT_UNIT = 1000;
    private static final int NO_AMOUNT = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
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
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateIsZero(int amount) {
        if (amount == NO_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0원 이상 입력해야 합니다.");
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
        return amount / LOTTO_PRICE;
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
