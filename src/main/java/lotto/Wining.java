package lotto;

import java.util.ArrayList;
import java.util.List;

public class Wining {

    private List<Integer> jackpot;
    private Integer bonus;

    public Wining() {
        jackpot = new ArrayList<>();
    }

    public void setWinningNumber(List<Integer> numbers){
        validateWins(numbers);
        jackpot = numbers;
    }

    private void validateWins(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateValidList(numbers);
        validateSizeOfNumber(numbers.size());
    }

    private void validateSizeOfNumber(int size) {
        if (size != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 숫자는 6개여야 합니다.");
        }
    }

    private void validateValidList(List<Integer> numbers) {
        for (int num:numbers) {
            validateValidNumber(num);
        }
    }

    private void validateValidNumber(int num){
        if (num <= 0 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1과 45 사이여야 합니다.");
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
        validateValidNumber(number);
        validateDupliWithJackpot(number);
    }

    private void validateDupliWithJackpot(Integer number) {
        for (int j: jackpot) {
            if (j == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안됩니다.");
            }
        }
    }

}
