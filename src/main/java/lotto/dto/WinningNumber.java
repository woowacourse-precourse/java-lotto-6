package lotto.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumber;
    private static final String DELIMITER = ",";
    private static final String OUT_RANGE_ERROR_MESSAGE = "[ERROR] 범위를 벗어난 숫자 입니다.";
    private static final String NULL_INPUT_ERROR_MESSAGE = "[ERROR] 금액을 정확히 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복 숫자가 존재합니다";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private WinningNumber(String userInput) {
        validateNullValue(userInput);
        try {
            this.winningNumber = Arrays
                    .stream(userInput.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validInRangeNumber();
            validateDuplicateNumber(winningNumber);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static WinningNumber create(String userInput){
        return new WinningNumber(userInput);
    }

    void validInRangeNumber(){
        for(int lottoNumber : winningNumber){
            if(lottoNumber < MIN_RANGE || lottoNumber > MAX_RANGE){
                throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
            }
        }
    }

    void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException(NULL_INPUT_ERROR_MESSAGE);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getWinningNumber(){
        return winningNumber;
    }
}
