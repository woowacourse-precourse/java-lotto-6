package model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {


    int bonus;
    List<Integer> winning_number;

    public WinningNumber(List<Integer> numbers, int bonus) {
        this.winning_number = numbers;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getWinning_number() {
        return winning_number;
    }

}
