package lotto.domain;

import java.util.List;

public class WinningLotto {

    List<LottoNumber> winningLotto;
    LottoNumber bonusNumber;


    public WinningLotto(List<String> winningLottoNumbers, String bonusNumber) {
        winningLotto = winningLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(number -> LottoNumber.of(number))
                .toList();
        this.bonusNumber = LottoNumber.of(Integer.parseInt(bonusNumber));
    }




}
