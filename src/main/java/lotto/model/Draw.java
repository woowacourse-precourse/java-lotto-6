package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private List<Integer> drawed =  new ArrayList<>();
    public Draw(List<Integer> ticket) {
        this.drawed = ticket;
    }
    public int match(List<Integer> numbers, int number) {
        return basic(numbers)+bonus(number);
    }
    public int basic(List<Integer> numbers) {
        int match = 0;
        for (int i : drawed) {
            match += isMatch(numbers, i);
        }
        return match;
    }
    public int bonus(int bonus) {
        if (drawed.contains(bonus))
            return 1;
        return 0 ;
    }
    public int isMatch(List<Integer> numbers, int number) {
        if (numbers.contains(number))
            return 1;
        return 0;
    }
    @Override
    public String toString() {
        return ""+drawed;
    }
}

