package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        inputRangeValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void inputRangeValidate(List<Integer> numbers){
        for (int number:numbers) {
            if(number<1 || number>45){
                throw new IllegalArgumentException();
            }
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
