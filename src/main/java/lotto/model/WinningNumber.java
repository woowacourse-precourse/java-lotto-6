package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final int WINNING_NUMBER_COUNT = 6;

    private final List<Integer> value;

    public WinningNumber(final String winningNumbers){
        validate(winningNumbers);
        value = makeValue(winningNumbers);
    }

    private void validate(String winningNumbers){
        if(isEmpty(winningNumbers)){
            throw new IllegalArgumentException();
        }

        if(isDigit(winningNumbers)){
            throw new IllegalArgumentException();
        }

        if(isSixNumbers(winningNumbers)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getValue(){
        return value;
    }

    private List<Integer> makeValue(final String winningNumbers){
        return Arrays.stream(winningNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private boolean isEmpty(final String winningNumbers){
        return winningNumbers.isBlank() || winningNumbers == null;
    }

    private boolean isDigit(String winningNumbers){
        return Arrays.stream(winningNumbers.split(",")).allMatch(number -> Character.isDigit(number.charAt(0)));
    }

    private boolean isSixNumbers(String winningNumbers){
        return winningNumbers.split(",").length == WINNING_NUMBER_COUNT;
    }
}

