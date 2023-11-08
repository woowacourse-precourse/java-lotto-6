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
    }

    public void setBonusNumber(Integer number){
        validateBonus(number);
        bonus = number;
    }

    private void validateBonus(Integer number) {
    }

}
