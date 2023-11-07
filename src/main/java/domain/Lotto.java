package domain;

import util.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private static final int LOTTO_GAME_NUMBERS_SIZE = 6;
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String SPACE = " ";
    private static final String NULL = "";

    private static final String COMMA = ",";

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        numbers = numbers.replace(SPACE, NULL);
        validateString(numbers);
        this.numbers = converStringListToIntegerList(convertStringToList(numbers));
    }

    private void validateString(String numbers){
        isStringEmpty(numbers);
        isStringDigit(convertStringToList(numbers));
        validate(converStringListToIntegerList(convertStringToList(numbers)));
    }

    private List<Integer> converStringListToIntegerList(List<String> numbers){
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void isStringEmpty(String numbers) {
        if(numbers == null || numbers.isBlank()){
            ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.throwException();
        };
    }

    private void isStringDigit(List<String> numbers){
        if(!(numbers.stream().allMatch(number -> number.chars().allMatch(Character::isDigit)))){
            ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.throwException();
        };
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(COMMA));
    }

    private void validate(List<Integer> numbers) {
        isSixNumbers(numbers);
        isBetweenLottoRange(numbers);
        isDuplicateNumber(numbers);
    }

    private void isDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            ExceptionMessage.LOTTO_DUPLICATE_VALUE.throwException();
        };
    }

    private void isBetweenLottoRange(List<Integer> numbers){
        if (numbers.stream().anyMatch(number -> number < LOTTO_GAME_START_NUMBER || number > LOTTO_GAME_END_NUMBER)) {
            ExceptionMessage.IS_RANGE_LOTTO.throwException();
        }
    }

    private void isSixNumbers(List<Integer> numbers){
        if(numbers.size() != LOTTO_GAME_NUMBERS_SIZE){
            ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.throwException();
        };
    }
}
