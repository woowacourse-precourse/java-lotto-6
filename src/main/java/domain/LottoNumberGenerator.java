package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    private List<Integer> lottoNumbers;

    LottoNumberGenerator() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
