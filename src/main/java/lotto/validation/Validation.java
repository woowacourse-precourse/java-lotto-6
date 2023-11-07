package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public static void validateLength(List<Integer> numbers, int length){
        if (numbers.size() != length) {
            ErrorMessage.lengthError(length);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            ErrorMessage.duplicationListError();
            throw new IllegalArgumentException();
        }

    }

    public static void validateNumberListInRange(List<Integer> numbers, int min, int max){
        for (int number : numbers) {
            validateNumberInRange(number, min, max);
        }
    }

    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            ErrorMessage.numberInRangeError(startInclusive, endInclusive);
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringIsInteger(String string){
        if (!string.chars().allMatch(Character::isDigit)) {
            ErrorMessage.stringToIntegerError();
            throw new IllegalArgumentException();
        }
    }
    public static void validateMultipleNumber(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != 0) {
            ErrorMessage.multipleNumberError(divisor);
            throw new IllegalArgumentException();
        }
    }

    public static void validateCertainNumberDuplicateInList(List<Integer> list,int number){
        if(list.contains(number)){
            ErrorMessage.validateCertainNumberDuplicateInList();
            throw new IllegalArgumentException();
        }
    }

    public static void validateListStringToInteger(List<String> list) {
        for(String string: list){
            validateStringIsInteger(string);
        }
    }
}
