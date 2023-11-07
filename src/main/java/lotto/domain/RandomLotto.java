package lotto.domain;

import java.util.List;

public class RandomLotto {
    private List<Lotto> RandomLottoNumbers;

    public RandomLotto(List<Lotto> randomLottoNumbers) {
        RandomLottoNumbers = randomLottoNumbers;
    }

    public List<Lotto> getRandomLottoNumbers() {
        return RandomLottoNumbers;
    }

}
