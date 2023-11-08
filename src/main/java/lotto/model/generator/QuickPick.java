package lotto.model.generator;

import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickPick implements LottoNumberGenerator {
    @Override
    public List<Integer> drawLots() {
        List<Integer> immutableLottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_OF_LOTTO_NUMBER.getDetails(),
                MAXIMUM_OF_LOTTO_NUMBER.getDetails(), COUNT_OF_LOTTO_NUMBER.getDetails());

        ArrayList<Integer> lottoNumbers = new ArrayList<>(immutableLottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
