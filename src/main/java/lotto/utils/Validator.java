package lotto.utils;

import java.util.Arrays;

import static lotto.constValue.ConstMessage.*;

public class Validator {
    public static void validateLottoPrice(String input){
        // null?
        if(isNullOrEmpty(input)){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        // 숫자 변환 -> 안되면 throw error
        if(!isNumber(input)){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateWinningNumbers(String input){
        // null?
        if(isNullOrEmpty(input)){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }

        String[] winningNumbers = input.split(",");

        // "," 기준으로 자름 -> 길이가 6?
        if(!isCorrectWinningNumbersLength(winningNumbers)){
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        // 자른 문자열 배열의 각 문자열이 숫자?
        if(!isNumbers(winningNumbers)){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        int[] convertWinningNumbers = Arrays.stream(winningNumbers).mapToInt(Integer::parseInt).toArray();

        // 각 숫자가 중복 있음?
        if(hasDuplicateInNumbers(convertWinningNumbers)){
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }

        // 각 숫자가 1~45 사이 숫자?
        if(!isNumbersInRange(convertWinningNumbers)){
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumber(String input){
        // null?
        if(isNullOrEmpty(input)){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        // 숫자 변환 -> 안되면 throw error
        if(!isNumber(input)){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        int bonusNumber = Integer.parseInt(input);

        // 변환 숫자가 1~45 사이?
        if(!isNumberInRange(bonusNumber)){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null;
    }

    private static boolean isCorrectWinningNumbersLength(String[] winningNumbers) {
        return winningNumbers.length == 6;
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isNumbers(String[] inputs){
        boolean answer = true;

        for(String input: inputs){
            if(!isNumber(input)){
                answer = false;
                break;
            }
        }

        return answer;
    }

    private static boolean isNumberInRange(int winningNumber){
        return winningNumber >= 1 && winningNumber <= 45;
    }

    private static boolean isNumbersInRange(int[] winningNumbers){
        boolean answer = true;

        for (int winningNumber : winningNumbers){
            if (!isNumberInRange(winningNumber)){
                answer = false;
                break;
            }
        }

        return answer;
    }

    private static boolean hasDuplicateInNumbers(int[] winningNumbers){
        return Arrays.stream(winningNumbers)
                .distinct()
                .count() != winningNumbers.length;
    }
}
