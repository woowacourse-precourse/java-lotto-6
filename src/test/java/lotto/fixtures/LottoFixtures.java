package lotto.fixtures;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoNumbers;

public class LottoFixtures {

    private static Lotto createLotto(int... numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers();

        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }

    public static Lotto createSixMatchedLotto() {
        return createLotto(1, 2, 3, 4, 5, 6);
    }

    public static Lotto createFiveAndBonusMatchedLotto() {
        return createLotto(1, 2, 3, 4, 5, 7);
    }

    public static Lotto createFiveMatchedLotto() {
        return createLotto(1, 2, 3, 4, 5, 8);
    }

    public static Lotto createFourMatchedLotto() {
        return createLotto(1, 2, 3, 4, 8, 9);
    }

    public static Lotto createThreeMatchedLotto() {
        return createLotto(1, 2, 3, 8, 9, 10);
    }

    public static Lotto createMissMatchedLotto() {
        return createLotto(1, 2, 8, 9, 10, 11);
    }
}
