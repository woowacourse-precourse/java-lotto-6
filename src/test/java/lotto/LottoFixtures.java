package lotto;

public class LottoFixtures {
    public static Lotto createSixMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        return new Lotto(lottoNumbers);
    }

    public static Lotto createFiveAndBonusMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        return new Lotto(lottoNumbers);
    }

    public static Lotto createFiveMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(8));

        return new Lotto(lottoNumbers);
    }

    public static Lotto createFourMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(8));
        lottoNumbers.add(new LottoNumber(9));

        return new Lotto(lottoNumbers);
    }

    public static Lotto createThreeMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(8));
        lottoNumbers.add(new LottoNumber(9));
        lottoNumbers.add(new LottoNumber(10));

        return new Lotto(lottoNumbers);
    }

    public static Lotto createMissMatchedWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(8));
        lottoNumbers.add(new LottoNumber(9));
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(11));

        return new Lotto(lottoNumbers);
    }
}
