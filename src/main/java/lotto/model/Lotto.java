package lotto.model;

import lotto.message.ExceptionMessage;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateLotto(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_6_NUMBER.getMessage());
        }
    }

    private void validateDuplicateLotto(List<Integer> numbers){
        int length = numbers.size();

        Set<Integer> checkDuplicate = new HashSet<>(numbers);

        if(length != checkDuplicate.size()){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void sortNumbers(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
