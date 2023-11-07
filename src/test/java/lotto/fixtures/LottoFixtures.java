package lotto.fixtures;

import java.util.List;
import lotto.domain.Lotto;

public class LottoFixtures {

    private static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createSixMatchedLotto() {
        return createLotto(List.of(1, 2, 3, 4, 5, 6));
    }

    public static Lotto createFiveAndBonusMatchedLotto() {
        return createLotto(List.of(1, 2, 3, 4, 5, 7));
    }

    public static Lotto createFiveMatchedLotto() {
        return createLotto(List.of(1, 2, 3, 4, 5, 8));
    }

    public static Lotto createFourMatchedLotto() {
        return createLotto(List.of(1, 2, 3, 4, 8, 9));
    }

    public static Lotto createThreeMatchedLotto() {
        return createLotto(List.of(1, 2, 3, 8, 9, 10));
    }

    public static Lotto createMissMatchedLotto() {
        return createLotto(List.of(1, 2, 8, 9, 10, 11));
    }

    public static Lotto createNormalLotto() {
        return createLotto(List.of(5, 3, 17, 18, 20, 21, 45));
    }

    public static Lotto createDuplicateLotto() {
        return createLotto(List.of(10, 5, 40, 35, 17, 10));
    }

    public static Lotto createOverSizeLotto() {
        return createLotto(List.of(10, 1, 40, 35, 17, 42, 5));
    }

    public static Lotto createUnderSizeLotto() {
        return createLotto(List.of(10, 1));
    }

    public static Lotto createLottoOutOfRange() {
        return createLotto(List.of(10, 1, 40, 35, 17, 42, 5));
    }
}
