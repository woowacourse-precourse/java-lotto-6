package lotto;

import static lotto.Constants.EMPTY;
import static lotto.Constants.NUMBERS_SIZE_ERROR;
import static lotto.Constants.NUMBER_COUNT;
import static lotto.Constants.NUMBER_DUPLICATE_ERROR;
import static lotto.Constants.REST;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputNumbers extends Input {

    protected void checkSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR);
        }
    }

    protected void checkDuplication(List<Integer> numbers) {
        Set<Integer> noDuplicationNumbers = new HashSet<>(numbers);
        if (numbers.size() != noDuplicationNumbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR);
        }
    }

    protected List<Integer> translateToValueType(String noEmptyReadLine) {
        if(noEmptyReadLine.startsWith(REST)) {
            noEmptyReadLine = noEmptyReadLine.substring(1);
        }
        String[] split = noEmptyReadLine.split(REST);
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
