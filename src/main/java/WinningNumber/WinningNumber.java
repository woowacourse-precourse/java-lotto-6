package WinningNumber;

import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private Integer bonusNum;

    public WinningNumber(List<Integer> numbers, Integer bonusNum){
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
