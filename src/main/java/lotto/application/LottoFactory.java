package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFactory {
    public Lotto createLottoByAuto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), LOTTO_COUNT.getValue()
        );
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        return new Lotto(lottoNumbers);
    }
}
