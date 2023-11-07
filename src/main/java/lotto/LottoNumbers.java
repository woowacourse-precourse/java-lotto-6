package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers() {
        numbers = new ArrayList<>();
    }

    public void add(final LottoNumber number) {
        numbers.add(number);
    }

    public List<Integer> convertToIntegerList() {
        return numbers.stream()
                .map(LottoNumber::num)
                .toList();
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(final int num) {
        return numbers.stream()
                .anyMatch(n -> n.num() == num);
    }
}
