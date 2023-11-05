package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchase {
    public static List<Lotto> buyLotto(long money) {
        List<Lotto> lottos = new ArrayList<>();

        long purchaseCount = money / 1000;
        while (lottos.size() != purchaseCount) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private static Lotto makeLotto() {
        return new Lotto(sortedNumbers(makeNumbers()));
    }

    private static List<Integer> makeNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> sortedNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
