package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningNumber(numbers);
        validateduplicateNumber(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("들어올 수 있는 숫자는 여섯 개 숫자 입니다.");
        }
    }

    // TODO: 추가 기능 구현

    // 보너스 숫자 넣기.
    public void bonusNumber(int number){
        validateBonusNumber(number);
        numbers.add(number);
    }

    //숫자 출력.
    public void outputLottoNumber(){
        for (Integer number : numbers) {
            System.out.print(number + ", ");
        }
    }

    // 보너스 숫자 입증 확인.
    private void validateBonusNumber(int number){
        for (Integer num : numbers) {
            if(num == number){
                throw new IllegalArgumentException("보너스 숫자는 기존 숫자와 중복 되면 안됩니다.");
            }
        }
    }


    // 1~45 숫자 입증 확인.
    private static void validateWinningNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < 1 || 45 < number){
                throw new IllegalArgumentException("숫자는 1~45 값이 되어야 합니다.");
            }
        }
    }

    //중복된 숫자 확인.
    private static void validateduplicateNumber(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 존재 합니다.");
        }
    }

}
