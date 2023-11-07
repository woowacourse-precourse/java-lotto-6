package lotto;

import java.util.ArrayList;
import java.util.List;

public class FixtureFactory {

    public static Lotto getLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return new Lotto(numbers);
    }
}
