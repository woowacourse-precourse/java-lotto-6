package lotto.domain.util;

import java.util.List;
import lotto.domain.numbergenerator.NumberGenerator;

public class SetNumberGenerator implements NumberGenerator {
    private List<Integer> setNumbers;
    public SetNumberGenerator(List<Integer> setNumbers) {
        this.setNumbers = setNumbers;
    }
    @Override
    public List<Integer> generate () {
        return setNumbers;
    }
}
