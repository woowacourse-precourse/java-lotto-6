package lotto.domain;

import lotto.utils.Constants;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_COUNT.getValues()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers){
        int prev_length = numbers.size();
        int post_length = (int)numbers.stream()
                .distinct()
                .count();
        if(prev_length!=post_length) throw new IllegalArgumentException();
    }

    private void validateNumber(List<Integer> numbers){
        for(int number:numbers){
            if(number<Constants.MIN_LOTTO_NUMBER.getValues()) throw new IllegalArgumentException();
            if(number>Constants.MAX_LOTTO_NUMBER.getValues()) throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public long getMatchedNumber(Lotto winningLotto){
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int getBonusNumber(Lotto winningLotto){
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return numbers.stream()
                .filter(num -> !winningNumbers.contains(num))
                .findFirst()
                .get();
    }

    private List<Integer> getNumbers(){
        return numbers;
    }
}
