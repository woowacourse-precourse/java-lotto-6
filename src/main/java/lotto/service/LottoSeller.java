package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Validator;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Lotto> lottos = new ArrayList<>();
    private int amount;


    public int getAmount(String userInput) {
        checkAmount(userInput);
        return this.amount;
    }

    public List<Lotto> giveLotto() {
        int countOfLotto = amount / LOTTO_PRICE;
        makeLottoPaper(countOfLotto);
        return new ArrayList<>(lottos);
    }

    public void makeLottoPaper(int countOfLotto) {
        for (int i = 1; i <= countOfLotto; i++) {
            lottos.add(generateAutoLotto());
        }
    }

    private void checkAmount(String userInput) {
        int amount;
        Validator.validateStringIsNumber(userInput);
        amount = Integer.parseInt(userInput);
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
