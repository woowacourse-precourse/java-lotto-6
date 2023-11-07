package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateWinningNumDuplication(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareLottoWithWinning(Lotto winningNum) {
        return (int) numbers.stream()
                .filter(winningNum::containNum)
                .count();
    }

    public boolean containNum(int number) {
        return numbers.contains(number);
    }

    public void validateBonus(Lotto winningNum,int bonus){
        validateRangeInt(bonus);
        if (containNum(bonus)) {
            ExceptionMessage.setInputDuplicateError();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.setInputSizeError();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                ExceptionMessage.setInputRangeError();
            }
        }
    }

    private void validateWinningNumDuplication(List<Integer> winningNum) {
       if(winningNum.size()!=winningNum.stream().distinct().count()){
           ExceptionMessage.setInputDuplicateError();
       }
    }

    private void validateRangeInt(int num) {
        if (num < 1 || num > 45) {
            ExceptionMessage.setInputRangeError();
        }
    }
}
