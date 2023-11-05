package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.Number;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class LottoSeller {
    private static final int LOTTO_PRICE = Number.LOTTO_PRICE.getNumber();
    private static final int LOTTO_NUMBER_START = Number.MIN_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_END = Number.MAX_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_COUNT = Number.FIXED_LOTTO_NUMBERS_COUNT.getNumber();
    private static final int NOTHING = 0;

    private final List<Lotto> lottos = new ArrayList<>();
    private int amount = NOTHING;

    public int getAmount(String userInput) {
        checkAmount(userInput);
        return this.amount;
    }

    public List<Lotto> giveLotto() {
        int countOfLotto = amount / LOTTO_PRICE;
        issueLottos(countOfLotto);
        return new ArrayList<>(lottos);
    }

    public void issueLottos(int countOfLotto) {
        for (int i = 1; i <= countOfLotto; i++) {
            lottos.add(generateAutoLotto());
        }
    }

    private void checkAmount(String userInput) {
        Validator.validateStringIsNumber(userInput);
        int amount = StringChanger.stringToInteger(userInput);
        Validator.validateNotLessThanNumber(amount, LOTTO_PRICE);
        Validator.validateDivisor(amount, LOTTO_PRICE);
        this.amount = amount;
    }

    private Lotto generateAutoLotto() {
        List<Integer> uniqueRandomNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START, LOTTO_NUMBER_END,
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(uniqueRandomNumbers);
    }
}
