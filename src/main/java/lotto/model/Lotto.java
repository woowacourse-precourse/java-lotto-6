package lotto.model;

import lotto.constants.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        int maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        int minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        int lottoSize = LottoConstant.LOTTO_SIZE.getConstant();

        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException();
        }
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        if(!numbers.stream().allMatch(num -> (num >= minValue && num <= maxValue))) {
            throw new IllegalArgumentException();
        }
    }

    public int getComparePrizeNumSameSize(ArrayList<Integer> prizeNum, int bonusNum) {
        List<Integer> checkSameSize = (List<Integer>) prizeNum.clone();
        checkSameSize.add(bonusNum);

        checkSameSize.retainAll(numbers);

        if(checkSameSize.size() == numbers.size() && !checkSameSize.contains(bonusNum)) {
            return numbers.size()+1;
        }

        return checkSameSize.size();
    }

    @Override
    public String toString() {
         return numbers.toString();
    }
}
