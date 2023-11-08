package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.LottoNumConstant;

public class LottoNumberGenerator {

    public static Lotto generateNum() {
        List<Integer> numbers = pickUniqueNumbersInRange(
            LottoNumConstant.LOTTO_MIN_NUM.getNumber(),
            LottoNumConstant.LOTTO_MAX_NUM.getNumber(),
            LottoNumConstant.LOTTO_SIZE.getNumber()
        );
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }
}
