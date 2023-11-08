package lotto.domain;

import lotto.util.Constants;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.lottoGroup;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        isNotDuplicate(numbers);
        isRightRange(numbers);
    }

    public void isNotDuplicate(List<Integer>numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException(Constants.NUM_DUPLICATE_EORROR);
        }
    }
    public static void isRightNums(String input){
        if (!Constants.numsStringPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(Constants.NUM_WRONG_ERROR);
        }
    }
    public void isRightRange(List<Integer>numbers){
        if(numbers.stream().anyMatch(num->num<1||num>45)){
            throw new IllegalArgumentException(Constants.NUM_SIZE_ERROR);
        }
    }
    public void sort() {
        numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

    }

    public void printResult(){
        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", Constants.LOTTO_START_BRACKET, Constants.LOTTO_END_BRACKET));
        System.out.println(result);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}