package lotto.domain;

import java.util.List;
import lotto.util.RandomUtils;

public class LottoNumbers {
    private List<Integer> LottoNumbers;

    public LottoNumbers(RandomUtils randomUtils) {
        this.LottoNumbers = randomUtils.generateRandomNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return LottoNumbers;
    }
}
