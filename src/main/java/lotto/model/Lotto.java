package lotto.model;

import java.util.Iterator;
import java.util.List;

public class Lotto {
    private static final String DISPLAY_BEGIN_MARK = "[";
    private static final String DISPLAY_END_MARK = "]";
    private static final String DISPLAY_SEPARATE_MARK = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Iterator<Integer> getIterator() {
        return numbers.iterator();
    }

    @Override
    public String toString() {
        StringBuilder formattedLottoNumbers = new StringBuilder();
        formattedLottoNumbers.append(DISPLAY_BEGIN_MARK);
        for (int index = 0; index < numbers.size(); index++) {
            formattedLottoNumbers.append(numbers.get(index));
            if (index != numbers.size() - 1) {
                formattedLottoNumbers.append(DISPLAY_SEPARATE_MARK);
            }
        }
        formattedLottoNumbers.append(DISPLAY_END_MARK);
        return formattedLottoNumbers.toString();
    }

    // TODO: 추가 기능 구현
}
