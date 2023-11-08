package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.enums.LottoSpec;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public Lotto createSingleLotto() {
        int lottoSize = LottoSpec.NUMBER_SIZE.getValue();
        int minNumber = LottoSpec.MIN_NUMBER.getValue();
        int maxNumber = LottoSpec.MAX_NUMBER.getValue();

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoSize);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

}
