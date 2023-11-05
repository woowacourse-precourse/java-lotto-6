package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.constant.NumberConstant;

public class RandomLottoNumbers implements LottoNumbers{

    @Override
    public List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers =  Randoms.pickUniqueNumbersInRange(
                NumberConstant.LOTTO_MIN_NUMBER.getNumber(),
                NumberConstant.LOTTO_MAX_NUMBER.getNumber(),
                NumberConstant.LOTTO_COUNT.getNumber()
        );
        sortLottoNumbers(randomNumbers);
        return randomNumbers;
    }

    private void sortLottoNumbers(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }
}
