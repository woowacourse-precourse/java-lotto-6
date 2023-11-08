package lotto.repository;

import lotto.model.LottoBonusNumber;
import lotto.model.LottoWinningNumbers;

public class LottoWinningRepository {

    private LottoWinningNumbers lottoWinningNumbers;
    private LottoBonusNumber lottoBonusNumber;

    public LottoWinningNumbers saveLottoWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        return lottoWinningNumbers;
    }

    public LottoWinningNumbers getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public LottoBonusNumber saveLottoBonusNumber(LottoBonusNumber lottoBonusNumber) {
        this.lottoBonusNumber = lottoBonusNumber;
        return lottoBonusNumber;
    }

    public LottoBonusNumber getLottoBonusNumber() {
        return lottoBonusNumber;
    }

}
