package lotto;

public class WinningLottoFixtures {


    public static WinningLotto createWinningLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);

        return new WinningLotto(lotto, bonusNumber);
    }
}
