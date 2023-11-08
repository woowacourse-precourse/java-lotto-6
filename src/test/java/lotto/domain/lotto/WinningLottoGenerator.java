package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.List;

public class WinningLottoGenerator {

    public static WinningLotto generateWinningLotto(List<Integer> numbers, int bonus) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .toList();

        return new WinningLotto(new LottoNumbers(lottoNumbers), LottoNumber.from(bonus));
    }
}
