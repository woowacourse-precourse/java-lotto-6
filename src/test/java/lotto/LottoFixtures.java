package lotto;

public class LottoFixtures {

    private static Lotto createLotto(int... numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers();

        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }

    public static Lotto createSixMatchedWinningLotto() {
        return createLotto(1, 2, 3, 4, 5, 6);
    }

    public static Lotto createFiveAndBonusMatchedWinningLotto() {
        return createLotto(1, 2, 3, 4, 5, 7);
    }

    public static Lotto createFiveMatchedWinningLotto() {
        return createLotto(1, 2, 3, 4, 5, 8);
    }

    public static Lotto createFourMatchedWinningLotto() {
        return createLotto(1, 2, 3, 4, 8, 9);
    }

    public static Lotto createThreeMatchedWinningLotto() {
        return createLotto(1, 2, 3, 8, 9, 10);
    }

    public static Lotto createMissMatchedWinningLotto() {
        return createLotto(1, 2, 8, 9, 10, 11);
    }
}
