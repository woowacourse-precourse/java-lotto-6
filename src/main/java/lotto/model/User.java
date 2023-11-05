package lotto.model;

import java.util.List;

public class User {

    private int bonus;
    private Lotto userLotto;

    public User(List<Integer> numbers, int bonus) {
        this.userLotto = new Lotto(numbers);
        this.bonus = bonus;
    }

}
