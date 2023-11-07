package lotto.exception.winningNumber;

import lotto.constant.Phrases;
import lotto.exception.CommonException;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberException extends CommonException {
    public void numberSizeOver(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Phrases.wrongSizeExceptionPhrase);
        }
    }

    public void numberDuplication(List<Integer> numbers) {
        List<Integer> newList =
                numbers.stream()
                        .distinct()
                        .collect(Collectors.toList());
        int afterSize = newList.size();

        if (numbers.size() != afterSize) {
            throw new IllegalArgumentException(Phrases.numberDuplication);
        }
    }
}
