package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Lotto> numbers;

    private User(List<Lotto> numbers) {
        this.numbers = numbers;
    }

    public static User of(List<Lotto> numbers) {
        return new User(numbers);
    }
}
