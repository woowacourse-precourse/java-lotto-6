package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    int numberCount = LottoConstant.LOTTO_NUMBER_COUNT.getValue();
    int minNumber = LottoConstant.MIN_LOTTO_NUMBER.getValue();
    int maxNumber = LottoConstant.MAX_LOTTO_NUMBER.getValue();

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, numberCount)
        );
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
