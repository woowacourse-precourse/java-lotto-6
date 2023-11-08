package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private static final int PRICE = 1000;
    private final int purchase;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_DIGIT = 6;

    public LottoSeller(int purchase) {
        validateNegativePurchase(purchase);
        validatePurchaseUnit(purchase);
        this.purchase = purchase;
    }

    public List<Lotto> sellLotto() {
        List<Lotto> lottos = IntStream.range(0, purchase / PRICE)
                .mapToObj((i) -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_DIGIT)))
                .collect(Collectors.toList());
        System.out.printf("%d개를 구매했습니다.%n", purchase / PRICE);

        return lottos;
    }

    private void validatePurchaseUnit(int purchase) {
        if (purchase % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력해야 합니다");
        }
    }

    private void validateNegativePurchase(int purchase) {
        if (purchase < 0) {
            throw new IllegalArgumentException("[ERROR] 양수가 아닌 금액이 입력되었습니다.");
        }
    }
}
