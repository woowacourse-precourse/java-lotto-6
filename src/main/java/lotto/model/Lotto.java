package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final int MIN_INCLUSIVE = 1;
    private final int MAX_INCLUSIVE = 45;

    private final List<Integer> numbers;

    public Lotto(String numbers) {
        numbers = numbers.replaceAll(" ","");
        validate(numbers);
        this.numbers = makeNumbers(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(final String numbers) {
        if(isEmpty(numbers)){
            throw new IllegalArgumentException();
        }

        if(!isDigit(numbers)){
            throw new IllegalArgumentException();
        }

        if(!isSixNumbers(numbers)){
            throw new IllegalArgumentException();
        }

        if(!isBetweenOneAndFortyFive(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> makeNumbers(final String numbers){
        return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private boolean isEmpty(final String numbers){
        return numbers.isBlank() || numbers == null;
    }

    private boolean isDigit(final String numbers){
        return Arrays.stream(numbers.split(",")).allMatch(number -> Character.isDigit(number.charAt(0)));
    }

    private boolean isSixNumbers(final String numbers){
        return numbers.split(",").length == LOTTO_NUMBER_SIZE;
    }

    private boolean isBetweenOneAndFortyFive(final String numbers){
        return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).allMatch(number -> number >= MIN_INCLUSIVE && number <= MAX_INCLUSIVE);
    }
}
