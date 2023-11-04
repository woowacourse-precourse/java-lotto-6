package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange
                (LottoNumber.getLottoNumberMinRange(),
                LottoNumber.getLottoNumberMaxRange(),
                Lotto.getLottoSize());
    }
}
