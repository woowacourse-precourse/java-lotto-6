package lotto.model;

import java.util.List;
import lotto.service.lottoService;
import lotto.util.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRedundantNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_SIZE.getMessage());
        }
    }


    private void validateRedundantNumbers(List<Integer> numbers) {
        List<Integer> distinctList = numbers.stream().distinct().toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException(ErrorCode.REDUNDANT_NUMBER.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Rank compare(WinningLotto winningNumber){
        int correctCount = compareWinningNumber(winningNumber);
        boolean bonusResult = compareBonusNumber(winningNumber);

        return Rank.match(correctCount,bonusResult);
    }

    public int compareWinningNumber(WinningLotto winningNumber){
        int count = 0;
        for(int i=0;i<winningNumber.getNumbers().size();i++){
            if(numbers.contains(winningNumber.getNumbers().get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean compareBonusNumber(WinningLotto winningNumber){
        return numbers.contains(winningNumber.getBonusNumber());
    }

}
