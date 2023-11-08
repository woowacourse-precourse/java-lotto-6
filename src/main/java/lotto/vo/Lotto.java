package lotto.vo;

import java.util.List;

import static lotto.values.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.values.LottoInformation.LAST_LOTTO_NUMBER;
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

    private void checkDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
                }
            }
        }
    }

    public StringBuilder getNumbersForPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        boolean[] isPrinted = new boolean[numbers.size()];
        while (i < TOTAL_LOTTO_NUMBER.getValue()) {
            int min = compareSize(isPrinted);
            if(i!=0) sb.append(", ");
            sb.append(min);
            i++;
        }
        sb.append("]");
        return sb;
    }

    private int compareSize(boolean[] isPrinted){
        int j;
        int min = LAST_LOTTO_NUMBER.getValue();
        for(j=0; j<isPrinted.length; j++){
            if(!isPrinted[j]) {
                min = Math.min(min, numbers.get(j));
            }
        }
        isPrinted[numbers.indexOf(min)] = true;
        return min;
    }

    public int countWinning(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < TOTAL_LOTTO_NUMBER.getValue(); i++) {
            if (winningNumbers.contains(numbers.get(i))) count++;
        }
        return count;
    }

    public boolean correctBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
