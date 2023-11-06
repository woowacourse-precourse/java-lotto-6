package lotto;

public class LottoNumbersFixtures {

    public static LottoNumbers createNormalLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(8));
        lottoNumbers.add(new LottoNumber(42));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(13));

        return lottoNumbers;
    }

    public static LottoNumbers createDuplicateLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(10));

        return lottoNumbers;
    }

    public static LottoNumbers createOverSizeLottoNumbers() {

        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(42));
        lottoNumbers.add(new LottoNumber(5));

        return lottoNumbers;
    }

    public static LottoNumbers createUnderSizeLottoNumbers() {

        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));

        return lottoNumbers;
    }

    public static LottoNumbers createLottoNumbersOutOfRange() {

        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(42));
        lottoNumbers.add(new LottoNumber(5));

        return lottoNumbers;
    }
}
