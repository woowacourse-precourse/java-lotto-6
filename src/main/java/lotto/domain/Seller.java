package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.Number;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class Seller {
    private static final int LOTTO_PRICE = Number.LOTTO_PRICE.getNumber();
    private static final int LOTTO_NUMBER_START = Number.MIN_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_END = Number.MAX_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_COUNT = Number.COUNT_OF_LOTTO_NUMBERS.getNumber();
    private static final int NOTHING = 0;

    private int amount = NOTHING;

    public void setAmount(String userInput) {
        amount = checkAmount(userInput);
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> giveLotto() {
        int countOfLotto = amount / LOTTO_PRICE;
        return issueLotteriesBy(countOfLotto);
    }

    public List<Lotto> issueLotteriesBy(int countOfLotto) {
        List<Lotto> lotteries = new ArrayList<>();
        while (countOfLotto > NOTHING) {
            lotteries.add(generateAutoLotto());
            countOfLotto--;
        }
        return lotteries;
    }

    private int checkAmount(String userInput) {
        Validator.validateIsNumber(userInput);
        int amount = StringChanger.toInteger(userInput);
        Validator.validateNotLessThan(amount, LOTTO_PRICE);
        Validator.validateIsDivisor(amount, LOTTO_PRICE);
        return amount;
    }

    private Lotto generateAutoLotto() {
        List<Integer> uniqueRandomNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START, LOTTO_NUMBER_END,
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(uniqueRandomNumbers);
    }
}
