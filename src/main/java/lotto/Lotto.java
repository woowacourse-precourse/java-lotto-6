package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> validSet = new HashSet<>(numbers);
        if(validSet.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복 없이 6개 입력해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto(){
        List<Integer> printLotto = new ArrayList<>(this.numbers);
        Collections.sort(printLotto);
        System.out.println(printLotto);
    }


    public Position checkLotto(List<Integer> correctNumbers, Integer bonusNumber){
        int checkCount = 0;
        for (Integer correctNumber : correctNumbers) {
            if(this.numbers.contains(correctNumber)){
                checkCount += 1;
            }
        }

        Position position = bonusCheck(bonusNumber, checkCount);
        if(position == null && checkCount >= 3){
            position = Position.valueOfPrint(checkCount + "개 일치");
        }

        return position;
    }

    private Position bonusCheck(Integer bonusNumber, int checkCount) {
        if(checkCount == 5){
            if(this.numbers.contains(bonusNumber)){
                return Position.EQUAL_5PLUS;
            }
        }
        return null;
    }
}
