package lotto.model;

import static lotto.model.enums.MagicVariable.NUMBERS_MIN_RANGE;
import static lotto.model.enums.MagicVariable.NUMBERS_MAX_RANGE;
import static lotto.model.enums.MagicVariable.NUMBERS_SIZE;
import static lotto.model.enums.MagicVariable.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.exception.LottoProcessException;

public class LottoProcess {
    public LottoProcess() {
    }

    public List<Lotto> purchaseLotto(String userMoney) {
        int money = purchaseAmount(userMoney);
        int numberOfLotto = money / LOTTO_PRICE.getNumber();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lotto.add(generateRandomLotto());
        }
        return lotto;
    }

    public int purchaseAmount(String userMoney) {
        LottoProcessException.checkLottoPriceNegativeException(userMoney);
        LottoProcessException.checkLottoPriceTypeException(userMoney);
        int money = Integer.parseInt(userMoney);
        LottoProcessException.checkLottoPriceRangeException(money);
        return money;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(NUMBERS_MIN_RANGE.getNumber(),
        NUMBERS_MAX_RANGE.getNumber(), NUMBERS_SIZE.getNumber());
        return new Lotto(randomNumbers);
    }
}
