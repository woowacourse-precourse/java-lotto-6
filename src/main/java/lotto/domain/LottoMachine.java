package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int defaultSalePrice = 1_000;
    private int lottoCount;

    public LottoMachine() {
    }

    public LottoMachine(int price) {
        validateUnitOfMoney(price);
        lottoCount = calculatePurchaseCount(price);
    }

    private void validateUnitOfMoney(int price) {
        if (price % defaultSalePrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
    }

    private int calculatePurchaseCount(int price) {
        return price / defaultSalePrice;
    }

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPurchasePrice() {
        return lottoCount * defaultSalePrice;
    }
}
