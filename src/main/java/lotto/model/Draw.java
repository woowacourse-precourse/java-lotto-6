package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private List<Integer> drawed =  new ArrayList<>();
    public Draw(List<Integer> ticket) {
        this.drawed = ticket;
    }
    @Override
    public String toString() {
        return ""+drawed;
    }
    // 방법이 생각안나서 임시로 만듦 => 리팩토링 꼭 해야됨
    public int match(List<Integer> numbers, int bonus) {
        int match = 0;
        for (int i : drawed) {
            match += isMatch(numbers, i);
        }
        if (drawed.contains(bonus)) match *= -1;
        return match;
    }
    public int isMatch(List<Integer> numbers, int number) {
        if (numbers.contains(number)) return 1;
        return 0;
    }
}

