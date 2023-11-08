package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private int amount;

    public LottoMachine() {
    }

    public LottoMachine(int inputAmount) {
        validateUnitOfMoney(inputAmount);
        amount = inputAmount;
    }

    private void validateUnitOfMoney(int inputAmount) {
        if (inputAmount % LottoConstant.defaultSalePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    public int calculatePurchaseCount() {
        return amount / LottoConstant.defaultSalePrice;
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_MIN_NUMBER,
                LottoConstant.LOTTO_MAX_NUMBER,
                LottoConstant.LOTTO_SIZE);
    }

    public Player generatePlayerLotto() {
        return new Player(IntStream.range(0, calculatePurchaseCount())
                .mapToObj(i -> new Lotto(generateLotto()))
                .collect(Collectors.toList()));
    }
}
