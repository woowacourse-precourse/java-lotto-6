package lotto.domain;

import java.util.List;

public class ParticularNumberGenerator implements NumberGenerator{

    private final List<Integer> particulatNumbers;

    public ParticularNumberGenerator(List<Integer> particulatNumbers) {
        this.particulatNumbers = particulatNumbers;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return particulatNumbers;
    }
}
