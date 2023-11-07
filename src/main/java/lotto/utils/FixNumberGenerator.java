package lotto.utils;

import java.util.List;

public class FixNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
