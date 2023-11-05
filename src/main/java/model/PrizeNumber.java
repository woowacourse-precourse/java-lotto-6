package model;

import java.util.List;

public class PrizeNumber {
    //당첨번호와 보너스번호를 관리

    private List<Integer> prizeNumber;
    private int bonousNumber;

    public void initPrizeNumber(List<Integer> numbers){
        prizeNumber = numbers;
    }
    public void initBonusNumber(int number){
        bonousNumber = number;
    }

    public List<Integer> getPrizeNumber() {
        return prizeNumber;
    }

    public int getBonousNumber() {
        return bonousNumber;
    }
}
