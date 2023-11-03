package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Constants.*;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final int VALID_REMAINING_AMOUNT = 0;

    public static List<Lotto> buyLotto(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        return createLottos(purchaseAmount / LOTTO_PRICE);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }
        if (isInvalidPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위어야 합니다.");
        }
    }

    private static boolean isInvalidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != VALID_REMAINING_AMOUNT;
    }

    private static List<Lotto> createLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
        return new Lotto(numbers);
    }
}
