package lotto.domain;

import lotto.constant.Errors;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        List<Integer> lottoNum = new ArrayList<>(numbers);
        Collections.sort(lottoNum);
        this.numbers = lottoNum;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Errors.WINNING_NUMBER_WRONG_SIZE_MESSAGE.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers){
        for(int i : numbers){
            if (i < 1 || i > 45){
                throw new IllegalArgumentException(Errors.WINNING_NUMBER_WRONG_RANGE_MESSAGE.getErrorMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for(Integer number : numbers){
            set.add(number);
        }
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException(Errors.WINNIG_NUMBER_DUPLICATE_MESSAGE.getErrorMessage());
        }
    }

    public void validateBonusNumber(int bonusNum){
        if(numbers.contains(bonusNum)){
            throw new IllegalArgumentException(Errors.BONUS_NUMBER_DUPLICATE_MESSAGE.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
}
