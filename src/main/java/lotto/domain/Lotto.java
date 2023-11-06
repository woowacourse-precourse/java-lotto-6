package lotto.domain;

import java.util.List;

import java.util.Collections;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLotto(){
        return lottoNumbers;
    }
}

