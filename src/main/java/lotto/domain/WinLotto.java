package lotto.domain;

import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonus_num;

    public WinLotto(List<Integer> numbers, int bonus_num) {
        this.numbers = numbers;
        this.bonus_num = bonus_num;
    }


}
