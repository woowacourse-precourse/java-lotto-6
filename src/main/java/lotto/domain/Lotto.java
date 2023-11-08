package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkNumber(List<Integer> numbers, Integer bonusNumber) {
        int number = (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();

        return checkbonusNumber(number,bonusNumber);
    }

    public int checkbonusNumber(int number, int bonusNumber) {

        if(number == 5){
            if(numbers.contains(bonusNumber)){
                return 6;
            }
        }else if(number == 6){
            return 7;
        }

        return number;
    }

}