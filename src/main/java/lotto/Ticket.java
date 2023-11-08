package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;

    Ticket() {
        this.numbers = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}