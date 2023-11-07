package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.enums.LottoNumber;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public Lotto createSingleLotto() {
        int lottoSize = LottoNumber.NUMBER_SIZE.getValue();
        int minNumber = LottoNumber.MIN_NUMBER.getValue();
        int maxNumber = LottoNumber.MAX_NUMBER.getValue();

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoSize);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

}
