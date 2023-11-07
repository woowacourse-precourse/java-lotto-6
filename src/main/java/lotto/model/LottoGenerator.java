package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_TICKET_SIZE = 6;
    private static final int LOTTO_TICKET_MINIMUM_PRICE = 1000;

    public Lotto generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms
                .pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_TICKET_SIZE);
        return new Lotto(randomNumbers);
    }

    public Lottos generateLottosByPurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountIsMultipleOfThousand(purchaseAmount);
        validateMinimumPurchaseAmount(purchaseAmount);

        int numberOfLottos = calculateNumberOfLottos(purchaseAmount);
        List<Lotto> lottos = IntStream.range(0, numberOfLottos)
                .mapToObj(i -> generateRandomLottoNumbers())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_MINIMUM_PRICE;
    }

    private void validatePurchaseAmountIsMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % LOTTO_TICKET_MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 티켓은 1,000원 단위로 구매가 가능합니다.");
        }
    }

    private void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_MINIMUM_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 티켓은 한 장당 1,000원입니다.");
        }
    }
}
