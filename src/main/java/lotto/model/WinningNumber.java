package lotto.model;

import java.util.List;

public class WinningNumber {
    private List<Integer> value;

    public WinningNumber(final String winningNumbers){
        validate(winningNumbers);
    }

    private void validate(final String winningNumbers){

    }

    private boolean isEmpty(final String winningNumbers){
        return winningNumbers.isBlank() || winningNumbers == null;
    }
}
