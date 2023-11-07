package lotto.vo;

import java.util.List;

import static lotto.values.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.values.LottoInformation.TOTAL_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplication(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            for(int j=i+1; j< numbers.size(); j++){
                if(numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
                }
            }
        }
    }
    public StringBuilder getNumbersForPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers);
        return sb;
    }

    public int countWinning(List<Integer> winningNumbers){
        int count = 0;
        for (int i = 0; i < TOTAL_LOTTO_NUMBER.getValue(); i++) {
            if (winningNumbers.contains(numbers.get(i))) count++;
        }

        return count;
    }

    public boolean correctBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
}
