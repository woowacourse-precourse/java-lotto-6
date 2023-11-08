package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    // TODO: 추가 기능 구현
    private final List<Integer> numbers;
    private int bonus;

    public int calculateNumbers(List<Integer> pickedNumber){
        int countWinning = 0;
        for(int num:pickedNumber){
            if(numbers.contains(num))countWinning++;
        }
        return countWinning;
    }
    public boolean isBonusinPicked(List<Integer> pickedNumber){
        return pickedNumber.contains(bonus);
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        //중복 및 길이 오류 체크
        List<Integer> dedupednum = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != 6 || dedupednum.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력되어야 합니다.");
        }
        for(Integer num : numbers){
            if(num < 1 || num > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 값입니다.");
        }
    }
}
