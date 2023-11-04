package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoPublisher {


    public LottoPublisher() {
    }

    public List<Lotto> publishLotto(Long purchaseAmount) {
        int purchasedLottoCount = calculateLottoAmount(purchaseAmount);
        return IntStream.range(0, purchasedLottoCount)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private int calculateLottoAmount(Long purchaseAmount) {
        return (int) (purchaseAmount / 1000);
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted(Integer::compareTo)
                .toList();

        return new Lotto(randomNumbers);
    }
}
