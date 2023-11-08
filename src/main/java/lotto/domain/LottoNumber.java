package lotto.domain;

import java.util.Collection;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String NUMBER_RANGE_ERROR = String.format("[ERROR]로또 숫자는 %d 이상 %d 이하의 숫자만 가능합니다.", MIN, MAX);
    private int number;
    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }
    private void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }
    protected boolean isContainedIn(Collection<Integer> numbers) {
        return numbers.contains(this.number);
    }
}
