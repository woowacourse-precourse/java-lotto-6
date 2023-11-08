package lotto;

import java.util.List;

public class ValidateService {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    public static void validateNumber(String number){
        if(!number.matches("\\d+")){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }
    public static void validateAuthorizedLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.BOUND_LENGTH.getErrorMessage());
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            validateNumberInRange(number);
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(
                    ErrorMessage.NON_PROPER_NUMS.getErrorMessage()
            );
        }
    }

    public static void validateDuplicatedNums(List<Integer> numbers) {
        int distinctNumbersCount = (int) numbers.stream().distinct().count();
        if (distinctNumbersCount != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NON_DUPLICATED_NUMS.getErrorMessage()
            );
        }
    }
    public static void validateDuplicatedNums(Integer num, List<Integer> numbers){
        numbers.add(num);
        validateDuplicatedNums(numbers);
    }
    public static void validateProperMoney(int money){
        if(money%LOTTO_PRICE!=0){
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getErrorMessage());
        }
    }

    public static void validateBonusInWinningNums(Integer bonus,List<Integer> numbers){
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_IN_WINNING_NUMBER.getErrorMessage());
        }
    }
}
