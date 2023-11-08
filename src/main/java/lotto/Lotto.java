package lotto;

import java.util.List;

import lotto.enums.MessageType;
import lotto.utils.InputUtils;
import lotto.utils.LottoUtils;
import lotto.utils.OutputUtils;

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
        if(LottoUtils.invalidLottoInput(numbers)){
            OutputUtils.printBasicMessage(MessageType.ERROR_DUPLICATE_WINNING_INPUTS);
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int compareAndGetCountOfMatchers(List<Integer> winningNumbers) {
        int cnt = 0;
        for(int target : this.numbers){
            if (isMatch(target, winningNumbers)) cnt++;
        }

        return cnt;
    }

    public boolean checkIfBonusNumberExists(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private boolean isMatch(int target, List<Integer> winningNumbers){
        for(int compare : winningNumbers){
            if(target == compare) return true;
        }

        return false;
    }
}
