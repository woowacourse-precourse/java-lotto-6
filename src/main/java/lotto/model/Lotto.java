package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        numbers = Randoms.pickUniqueNumbersInRange(NumberConstant.LOTTO_NUMBER_MIN,
                NumberConstant.LOTTO_NUMBER_MAX, NumberConstant.LOTTO_NUMBER_COUNT);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        outOfRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_COUNT_WINNING_NUMBER);
        }
    }

    private void duplicate(List<Integer> numbers){
        int size = numbers.size();
        for(int i=0; i<size-1; i++){
            int baseNumber = numbers.get(i);
            List<Integer> subNumbers = numbers.subList(i+1,size);
            duplicateCheck(subNumbers, baseNumber);
        }
    }

    private void duplicateCheck(List<Integer> subNumbers, int baseNumber){
        if(subNumbers.contains(baseNumber)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
        }
    }

    private void outOfRange(List<Integer> numbers){
        for(int number : numbers){
            outOfRangeDetail(number);
        }
    }

    private void outOfRangeDetail(int number){
        if(number < NumberConstant.LOTTO_NUMBER_MIN || number > NumberConstant.LOTTO_NUMBER_MAX){
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_WINNING_NUMBER);
        }
    }

    public List<Integer> getSortedNumbers(){
        return numbers.stream().sorted().toList();
    }

    public boolean containsNumber(int number){
        return numbers.contains(number);
    }

    public int checkNumberInLotto(int number){
        if(containsNumber(number)){
            return 1;
        }
        return 0;
    }
}
