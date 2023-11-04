package lotto.model;

import static lotto.model.MagicVariable.NUMBERS_MIN_RANGE;
import static lotto.model.MagicVariable.NUMBERS_MAX_RANGE;
import static lotto.model.MagicVariable.NUMBERS_SIZE;
import static lotto.model.MagicVariable.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.exception.LottoProcessException;

public class LottoProcess {
    public List<Lotto> purchaseLotto(int money) {
        LottoProcessException.checkPurchaseMoney(money);
        int numberOfLotto = money / LOTTO_PRICE.getNumber();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lotto.add(generateRandomLotto());
        }
        return lotto;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(NUMBERS_MIN_RANGE.getNumber(),
        NUMBERS_MAX_RANGE.getNumber(), NUMBERS_SIZE.getNumber());
        return new Lotto(randomNumbers);
    }
}
