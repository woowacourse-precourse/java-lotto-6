package lotto.domain;

import java.util.List;
import lotto.Message.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.toString());
        }

        for(int i = 0; i < numbers.size(); i++){
            if (numbers.contains(numbers.get(i))){
                throw new IllegalArgumentException(ErrorMessage.LOTTON_NUMBER_DUPLICATION.toString());
            }else if (1 > numbers.get(i) && numbers.get(i) > 45){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.toString());
            }
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