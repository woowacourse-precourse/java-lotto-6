package lotto.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
        if(Collections.max(numbers)>Constants.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException();
        }
        if(Collections.min(numbers)<Constants.LOTTO_MIN_NUMBER){
            throw new IllegalArgumentException();
        }
    }
    public int countMatch(Lotto winnigNumbers){
        return (int)numbers.stream()
                .filter(winnigNumbers::isContainNumber)
                .count();
    }
    public boolean isContainNumber (int number){
        return numbers.contains(number);
    }
    public String printNumbers(){
        String resultNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(resultNumbers);
        return resultNumbers;
    }
    // TODO: 추가 기능 구현
}
