package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final String MESSAGE_AMOUNT_MUST_BE_POSITIVE = "[ERROR] 금액은 0보다 커야합니다.";
    private static final String MESSAGE_MUST_MULTIPLE_OF_LOTTO_PRICE = "[ERROR] 금액은 로또 금액("+LOTTO_PRICE+")의 배수여야 합니다.";

    public ArrayList<Lotto> generateLottoBundle(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException(MESSAGE_AMOUNT_MUST_BE_POSITIVE);
        if (amount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(MESSAGE_MUST_MULTIPLE_OF_LOTTO_PRICE);

        int lottoCount = amount / LOTTO_PRICE;
        ArrayList<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.add(generateRandomLotto());
        }

        return lottoBundle;
    }

    public Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(new ArrayList<>(numbers));
        return new Lotto(numbers);
    }
}
