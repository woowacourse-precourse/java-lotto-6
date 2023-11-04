package domain;

import view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUniqueValue(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int value : numbers){
            if (value >= MIN_LOTTO_NUMBER && value <= MAX_LOTTO_NUMBER){
                continue;
            }
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueValue(List<Integer> numbers){
        if (!checkUniqueValue(numbers)){
            ExceptionMessage.uniqueException();
            throw new IllegalArgumentException();
        }
    }

    private boolean checkUniqueValue(List<Integer> numbers){
        Set<Integer> checkUnique = new HashSet<>();
        for (int value : numbers){
            if (!checkUnique.add(value)){
                return false;
            }
        }
        return true;
    }

    public static int checkInteger(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }

}
