package lotto.model;

import java.util.List;

public class WinningNumber {

    private static final int WINNING_NUMBER_COUNT = 6;

    private List<Integer> value;

    public WinningNumber(final String winningNumbers){
        validate(winningNumbers);
    }

    private void validate(String winningNumbers){
        if(isEmpty(winningNumbers)){
            throw new IllegalArgumentException();
        }

        winningNumbers = removeCommas(winningNumbers);

        if(isDigit(winningNumbers)){
            throw new IllegalArgumentException();
        }

        if(isSixNumbers(winningNumbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(final String winningNumbers){
        return winningNumbers.isBlank() || winningNumbers == null;
    }

    private boolean isDigit(String winningNumbers){

        for (int i = 0; i < winningNumbers.length(); i++) {
            if(!Character.isDigit(winningNumbers.charAt(i))) return false;
        }

        return true;
    }

    private boolean isSixNumbers(String winningNumbers){
        return winningNumbers.length() == WINNING_NUMBER_COUNT;
    }

    private String removeCommas(final String winningNumbers){
        return winningNumbers.replace(",","");
    }
}

