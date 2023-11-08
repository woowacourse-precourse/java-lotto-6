package lotto;

import lotto.variables.ErrorMessages;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_ERROR.getErrorMessage());
        }
    }

    public boolean hasBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }

    public int countLottery(List<Integer> lotteryList) {
        int res = 0;
        
        return countLottery(lotteryList, res);
    }

    private int countLottery(List<Integer> lotteryList, int res) {
        for(int number : numbers){
            if (lotteryList.contains(number)) res++;
        }
        return res;
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString(){
        return numbers.toString();
    }
}
