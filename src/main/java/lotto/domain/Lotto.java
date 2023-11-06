package lotto.domain;

import static lotto.enums.Constants.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ExceptionMessages;
import lotto.utils.RemoveSpace;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(String numbers) {
        numbers = RemoveSpace.getValue(numbers);
        validate(numbers);
        this.numbers = makeNumbers(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(final String numbers) {
        if(isEmpty(numbers)){
            ExceptionMessages.LOTTO_IS_EMPTY.throwException();
        }

        if(!isDigit(numbers)){
            ExceptionMessages.LOTTO_IS_NOT_NUMER.throwException();
        }

        if(!isSixNumbers(numbers)){
            ExceptionMessages.LOTTO_SIZE_IS_OVER_SIX.throwException();
        }

        if(!isBetweenOneAndFortyFive(numbers)){
            ExceptionMessages.LOTTO_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE.throwException();
        }

        if(isDuplicatedNumber(numbers)){
            ExceptionMessages.LOTTO_IS_DUPLICATED.throwException();
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
        return numbers.split(",").length == LOTTO_NUMBER_SIZE.getValue();
    }

    private boolean isBetweenOneAndFortyFive(final String numbers){
        return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).allMatch(number -> number >= MIN_INCLUSIVE.getValue() && number <= MAX_INCLUSIVE.getValue());
    }

    private boolean isDuplicatedNumber(final String numbers){

        Set<String> set = new HashSet<>(List.of(numbers.split(",")));

        return set.size() != numbers.split(",").length;
    }
}
