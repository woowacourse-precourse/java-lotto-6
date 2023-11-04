package domain;

import view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateUniqueValue(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int value : numbers){
            if (value >= 1 && value <= 45){
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
