package lotto.model;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public List<Integer> getNumbers() {
        return this.lottoNumbers;
    }
}
