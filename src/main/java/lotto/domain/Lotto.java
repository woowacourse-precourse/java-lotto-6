package lotto.domain;

import static java.util.Collections.sort;

import java.util.Comparator;
import java.util.List;

public class Lotto extends LottoNumber {
    private List<Integer> numbers;

    public Lotto(int lottoNumber) {
        super(lottoNumber);
    }
    public Lotto(List<Integer> numbers) {
        super();
        numbers.forEach(Lotto::new);
        sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isLottoSizeValid(numbers,LOTTO_SIZE);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        int count = 0;

        for (Integer number : numbers) {
            if (otherLotto.containsNumber(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
