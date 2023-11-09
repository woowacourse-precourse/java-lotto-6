package lotto.domain;

import static lotto.constants.LottoConstants.LENGTH;

import java.util.List;
import lotto.exception.LottoNumbersDuplicationException;
import lotto.exception.WrongLottoLengthException;

public class WinningLotto {


    List<LottoNumber> winningLotto;
    LottoNumber bonusNumber;

    private WinningLotto(List<Integer> winningLottoNumbers, Integer bonusNumber) {

        checkDuplication(winningLottoNumbers);
        checkLength(winningLottoNumbers);

        winningLotto = winningLottoNumbers.stream()
                                          .map(LottoNumber::valueOf)
                                          .toList();

        this.bonusNumber = LottoNumber.valueOf(bonusNumber);

    }

    public static WinningLotto from(List<String> lottoNumbers, String decidedBonusNumber) {

        List<Integer> winningLottoNumbers = lottoNumbers.stream()
                                                        .map(Integer::parseInt)
                                                        .toList();

        Integer bonusNumber = Integer.parseInt(decidedBonusNumber);

        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }

    public boolean hasBonusNumberIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }


    private void checkDuplication(List<Integer> winningLotto) {

        List<Integer> distinctList = winningLotto.stream()
                                                 .distinct()
                                                 .toList();

        if (distinctList.size() != winningLotto.size()) {

            throw new LottoNumbersDuplicationException();

        }
    }

    private void checkLength(List<Integer> lottoNumbers) {

        if (lottoNumbers.size() != LENGTH) {

            throw new WrongLottoLengthException();

        }
    }

}
