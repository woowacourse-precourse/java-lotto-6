package lotto.util;

import java.util.List;

public abstract class LottoNumbersGenerator {
    protected List<Integer> numbers;
    protected static final int START_INCLUSIVE = 1;
    protected static final int END_INCLUSIVE = 45;
    protected static final int COUNT = 6;

    protected abstract void generateLottoNumbers();

    public List<Integer> getSortedLottoNumbers() {
        generateLottoNumbers();
        numbers.sort(null);
        return numbers;
    }
}
