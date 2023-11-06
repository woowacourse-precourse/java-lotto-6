package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    public static List<Lotto> buyLotto(long money) {
        validateMoney(money);
        List<Lotto> lottos = new ArrayList<>();

        long purchaseCount = money / 1000;
        while (lottos.size() != purchaseCount) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private static void validateMoney(long money) {
        if (isLackMoney(money)) {
            throw new IllegalArgumentException("금액은 1,000원 이상 투입 되어야 합니다.");
        }

        if (isWrongMoney(money)) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 투입 되어야 합니다.");
        }
    }

    private static boolean isLackMoney(long money) {
        return money < 1000;
    }

    private static boolean isWrongMoney(long money) {
        return money % 1000 != 0;
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
