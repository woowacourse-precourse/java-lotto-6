package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class WinningNumber {
    private static final String LOTTO_NUMBER_REGEXP = "^[0-9,]+$";
    private final List<Integer> winningNumbers;

    public  WinningNumber(String input){
        validateInput(input);
        List<Integer> winningNumbers =parseWinningNumbers(input);
        validateWinningRange(winningNumbers);
        validateWinningLength(winningNumbers);
        validateWinningOverlap(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    private void validateInput(String input){
        if(!Pattern.matches(LOTTO_NUMBER_REGEXP,input)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_TYPE.getMessage());
        }
    }

    private void validateWinningLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_LENGTH.getMessage());
        }
    }

    private void validateWinningOverlap(List<Integer> winningNumbers){
        Set<Integer> set = new HashSet<>(winningNumbers);

        if( set.size() != winningNumbers.size()){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_OVERLAP.getMessage());
        }
    }

    private void validateWinningRange(List<Integer> winningNumbers){
        for(int number: winningNumbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_RANGE.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input){
        String[] numbersStr = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String numberStr : numbersStr) {
            winningNumber.add(Integer.parseInt(numberStr.trim())); // trim()은 공백을 제거합니다.
        }
        Collections.sort(winningNumber);

        return winningNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
