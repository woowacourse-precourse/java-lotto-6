package lotto;

import java.util.ArrayList;
import java.util.List;

public class Wining {

    private List<Integer> jackpot = new ArrayList<>();
    private Integer bonus;

    public Wining() {
    }

    public void setWinningNumber(List<Integer> numbers){
        validateWins(numbers);
        jackpot = numbers;
    }

    private void validateWins(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateValidNumber(numbers);
        validateSizeOfNumber(numbers.size());
    }

    private void validateSizeOfNumber(int size) {
        if (size != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 숫자는 6개여야 합니다.")
        }
    }

    private void validateValidNumber(List<Integer> numbers) {
        for (int num:numbers) {
            if (num <= 0 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1과 45 사이여야 합니다.");
            }
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        long size = numbers.stream().distinct().count();

        if (size != 6){
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(Integer number){
        validateBonus(number);
        bonus = number;
    }

    private void validateBonus(Integer number) {
    }

}
