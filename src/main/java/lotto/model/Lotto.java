package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
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

        List<Integer> sortedLottoNumbers = getSortedLottoNumbers();
        for (int index = 0; index < sortedLottoNumbers.size(); index++) {
            formattedLottoNumbers.append(sortedLottoNumbers.get(index));
            if (index != sortedLottoNumbers.size() - 1) {
                formattedLottoNumbers.append(DISPLAY_SEPARATE_MARK);
            }
        }
        formattedLottoNumbers.append(DISPLAY_END_MARK);
        return formattedLottoNumbers.toString();
    }


    private List<Integer> getSortedLottoNumbers() {
        List<Integer> sortedLottoNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }
    // TODO: 추가 기능 구현
}
