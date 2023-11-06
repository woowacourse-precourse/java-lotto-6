package lotto.domain;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;
import static lotto.settings.ErrorMessage.INVALID_COUNT;
import static lotto.settings.ErrorMessage.INVALID_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }
    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        int uniqueSize = numbers.stream().distinct().toList().size();
        if(numbers.size() != uniqueSize){
            throw new IllegalArgumentException(DUPLICATE_NUM.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException(INVALID_RANGE.getMessage());
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String listToString(){
        String[] array = numbers.stream()
                                .sorted()
                                .map(String::valueOf)
                                .toArray(String[]::new);
        return String.join(", ", array);
    }

    public int matching(Lotto buyLotto) {
        int cnt=0;
        List<Integer> buyNumbers = buyLotto.getNumbers();
        for (Integer nuyNumber : buyNumbers) {
            if (numbers.contains(nuyNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int findRank(int correctNum,int bonusNum){
        if(correctNum ==3) return 5;
        else if(correctNum ==4) return 4;
        else if(correctNum ==5){
            if(numbers.contains(bonusNum)) return 2;
            return 3;
        } else if (correctNum ==6) {
            return 1;
        }
        return 0;
    }

    public boolean has(int bonusNum){
        return numbers.contains(bonusNum);
    }
}
