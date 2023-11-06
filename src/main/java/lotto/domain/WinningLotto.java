package lotto.domain;

import static lotto.constants.LottoConstants.LENGTH;

import java.util.List;
import lotto.exception.BonusNumberDuplicationException;
import lotto.exception.LottoNumbersDuplicationException;
import lotto.exception.WrongLottoLengthException;

public class WinningLotto {


    List<LottoNumber> winningLotto;
    LottoNumber bonusNumber;

    public WinningLotto(List<String> winningLottoNumbers, String bonusNumber) {

        checkDuplication(winningLottoNumbers);
        checkDuplicationFrom(winningLottoNumbers, bonusNumber);
        checkLength(winningLottoNumbers);
        winningLotto = winningLottoNumbers.stream()
                                          .map(Integer::parseInt)
                                          .map(number -> LottoNumber.valueOf(number))
                                          .toList();
        this.bonusNumber = LottoNumber.valueOf(Integer.parseInt(bonusNumber));

    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }

    public boolean hasBonusNumberIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }


    private void checkDuplication(List<String> winningLotto) {
        List<String> distinctList = winningLotto.stream()
                                                .distinct()
                                                .toList();
        if (distinctList.size() != winningLotto.size()) {
            throw new LottoNumbersDuplicationException();
        }
    }

    private void checkDuplicationFrom(List<String> winningLotto, String bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new BonusNumberDuplicationException();
        }
    }

    private void checkLength(List<String> lottoNumbers) {
        if (lottoNumbers.size() != LENGTH) {
            throw new WrongLottoLengthException();
        }
    }

}
