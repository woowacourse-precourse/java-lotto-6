package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoPurchase {
    public static List<Lotto> buyLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() != purchaseCount) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private static Lotto makeLotto() {
        return new Lotto(sortedNumbers(makeNumbers()));
    }

    private static List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private static List<Integer> makeNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
