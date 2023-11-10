package lotto;

import lotto.variables.ErrorMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> tmp = getSortedList(numbers);
        this.numbers = tmp;
    }

    private static List<Integer> getSortedList(List<Integer> numbers) {
        List<Integer> tmp = new ArrayList<>(numbers);
        Collections.sort(tmp);
        return tmp;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_ERROR.getErrorMessage());
        }

        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_DUP_ERROR.getErrorMessage());
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
