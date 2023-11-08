package lotto.model;

import java.util.List;
import lotto.service.lottoService;

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
