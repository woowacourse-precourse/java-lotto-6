package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.NumberRule;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class Seller {
    private static final int LOTTO_PRICE = NumberRule.LOTTO_PRICE.getNumber();
    private static final int MAX_AMOUNT = NumberRule.MAX_AMOUNT.getNumber();
    private static final int MIN_LOTTO_NUMBER = NumberRule.MIN_LOTTO_NUMBER.getNumber();
    private static final int MAX_LOTTO_NUMBER = NumberRule.MAX_LOTTO_NUMBER.getNumber();
    private static final int COUNT_OF_LOTTO_NUMBERS = NumberRule.COUNT_OF_LOTTO_NUMBERS.getNumber();
    private static final int NOTHING = 0;

    private int amount = NOTHING;

    public void setAmount(String userInput) {
        amount = checkAmount(userInput);
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> giveLotto() {
        int theNumberOfLotto = amount / LOTTO_PRICE;
        return issueLotteriesBy(theNumberOfLotto);
    }

    public List<Lotto> issueLotteriesBy(int theNumberOfLotto) {
        List<Lotto> lotteries = new ArrayList<>();
        while (theNumberOfLotto > NOTHING) {
            lotteries.add(generateAutoLotto());
            theNumberOfLotto--;
        }
        return lotteries;
    }

    private int checkAmount(String userInput) {
        Validator.validateIsNumber(userInput);
        int amount = StringChanger.toInteger(userInput);
        Validator.validateNotLessThan(amount, LOTTO_PRICE);
        Validator.validateNotGreaterThan(amount, MAX_AMOUNT);
        Validator.validateIsDivisor(amount, LOTTO_PRICE);
        return amount;
    }

    private Lotto generateAutoLotto() {
        List<Integer> uniqueRandomNumbers = Randoms.pickUniqueNumbersInRange
                (
                        MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                        COUNT_OF_LOTTO_NUMBERS
                );
        return new Lotto(uniqueRandomNumbers);
    }
}
