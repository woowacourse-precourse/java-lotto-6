package domain;

import util.exception.DuplicateException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.message.ExceptionMessage.DUPLICATE_MESSAGE;

public class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(final List<Integer> inputWinningNumbers) {
        validateDuplicate(inputWinningNumbers);
        numbers = inputWinningNumbers;
    }

    public static WinningNumbers create(final List<Integer> inputWinningNumbers){
        return new WinningNumbers(inputWinningNumbers);
    }

    private void validateDuplicate(final List<Integer> inputWinningNumbers){
        Set<Integer> numbers = new HashSet<>(inputWinningNumbers);
        if(numbers.size() != inputWinningNumbers.size()){
            throw new DuplicateException(String.format(DUPLICATE_MESSAGE.getValue()));
        }
    }
}
