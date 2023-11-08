package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int defaultSalePrice = 1_000;
    private int amount;

    public LottoMachine() {
    }

    public LottoMachine(int inputAmount) {
        validateUnitOfMoney(inputAmount);
        amount = inputAmount;
    }

    private void validateUnitOfMoney(int inputAmount) {
        if (inputAmount % defaultSalePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    public int calculatePurchaseCount() {
        return amount / defaultSalePrice;
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    public Player generatePlayerLotto() {
        return new Player(IntStream.range(0, calculatePurchaseCount())
                .mapToObj(i -> new Lotto(generateLotto()))
                .collect(Collectors.toList()));
    }
}
