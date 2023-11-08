package model;

import java.util.List;

public class PrizeNumber {

    private List<Integer> prizeNumber;
    private int bonousNumber;

    public void initPrizeNumber(List<Integer> numbers) {
        prizeNumber = numbers;
    }

    public void initBonusNumber(int number) {
        bonousNumber = number;
    }

    public List<Integer> getPrizeNumber() {
        return prizeNumber;
    }

    public int getBonousNumber() {
        return bonousNumber;
    }
}
