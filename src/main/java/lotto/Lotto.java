package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        inputRangeValidate(numbers);
        inputDuplicateValidate(numbers);
        List<Integer> modifyableList = new ArrayList<>(numbers);
        modifyableList.sort(Comparator.naturalOrder());
        this.numbers = modifyableList;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("크기가 맞지 않습니다.");
        }
    }

    private void inputRangeValidate(List<Integer> numbers){
        for (int number:numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException("범위에 맞지 않는 입력값입니다.");
            }
        }
    }

    private void inputDuplicateValidate(List<Integer> numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException("같은 숫자가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public PRIZE Score(List<Integer> winNumbers, int bonus){
        int matchCount=0;
        boolean bonusMatch=false;

        for (int number:numbers) {
            if(bonus==number){
                bonusMatch=true;
            }
            if(winNumbers.contains(number)){
                matchCount++;
            }
        }

        if(matchCount<3){
            return PRIZE.FAIL;
        }
        if(matchCount==3){
            return PRIZE.FIFTH;
        }
        if(matchCount==4){
            return PRIZE.FORTH;
        }
        if(matchCount==5){
            if(bonusMatch){
                return PRIZE.SECOND;
            }
            return PRIZE.THIRD;
        }
        return PRIZE.FIRST;
    }
}
