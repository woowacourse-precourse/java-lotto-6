package domain;

import java.util.List;

public class User {

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public User(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }


}
