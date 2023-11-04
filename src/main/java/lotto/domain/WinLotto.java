package lotto.domain;

import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonus_num;

    public void setBonus_num(int bonus_num) {
        this.bonus_num = bonus_num;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
