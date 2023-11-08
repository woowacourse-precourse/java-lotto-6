package lotto.domain;

import lotto.consts.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.consts.ConstsString.LOTTO_NUMBERS;
import static lotto.consts.ConstsString.MAX_LOTTO_NUMBER;
import static lotto.consts.ConstsString.MIN_LOTTO_NUMBER;
import static lotto.consts.ConstsString.DELIMETER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkValidSplit(numbers);
        checkLottoSize(numbers);
        checkValidNumber(numbers);
        checkDupliacted(numbers);
    }


    private void checkLottoSize(List<Integer> numbers){
        if(numbers.size() != LOTTO_NUMBERS){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void checkValidSplit(List<Integer> numbers){
        String userInput = numbers.toString();
        if(!userInput.contains(DELIMETER)){
            throw new IllegalArgumentException(ExceptionMessage.WRONG_SEPERATOR_ERROR.getMessage());
        }
    }

    private void checkValidNumber(List<Integer> numbers){
        for(int lottoNumber : numbers){
            if(lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_NUMBER.getMessage());
            }
        }
    }

    private void checkDupliacted(List<Integer> numbers){
        Set<Integer> lottoSet = new HashSet<>();
        for(int number : numbers){
            lottoSet.add(number);
        }
        if(lottoSet.size() != numbers.size()){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_VALUE_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}