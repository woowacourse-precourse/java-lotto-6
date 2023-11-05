package lotto;

import lotto.domain.*;

public class LottoDraw {

    LottoNumber lottoNumber = new LottoNumber();
    LottoNumbers lottoNumbers = new LottoNumbers();

    public void startLottoDraw() {

        Lotto[] lottoNumbers = pickLottoNumbers();
        Lotto winnerNumbers = pickWinnerNumbers();
        int bonusNumber = pickBonusNumber(winnerNumbers);



    }

    public int getPurchaseAmount() {
        return lottoNumber.inputPurchaseAmount();
    }

    public Lotto[] pickLottoNumbers() {
        int numberOfLotto = getPurchaseAmount() / 1000;
        return lottoNumbers.pickLottoNumbers(numberOfLotto);
    }

    public Lotto pickWinnerNumbers() {
        return lottoNumber.inputWinnerNumbers();
    }

    public int pickBonusNumber(Lotto lotto) {
        return lottoNumber.inputBonusNumber(lotto);
    }


}
