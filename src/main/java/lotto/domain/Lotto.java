package lotto.domain;

import static lotto.validation.LottoValidation.validate_lottoNum;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.constant.WinningRanking;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNums();
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNums() {
        validate_lottoNum(numbers);
    }

    private void ascendingNumbers(){
        Collections.sort(numbers);
    }

    public int getRank(List<Integer> nums, int bonusNum){

        int matchCnt = getMatchCnt(nums);

        if(WinningRanking.RANK2.getMatchNumCnt() == matchCnt){
            return checkBonus(bonusNum);
        }

        for (WinningRanking rank : WinningRanking.values()){
            if(rank.getMatchNumCnt() == matchCnt){
                return rank.getRanking();
            }
        }
        return -1;
    }

    private int getMatchCnt(List<Integer> nums) {
        List<Integer> result = Stream.concat(numbers.stream(), nums.stream()).toList();
        return 12 - Set.copyOf(result).size();
    }

    private int checkBonus(int bonusNum) {
        if(numbers.contains(bonusNum)){
            return 2;
        }
        return 3;
    }
}
