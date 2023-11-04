package lotto.domain;

import java.util.List;

public class Player {
    private int payment;
    private List<Integer> numbers;
    private int plusNumber;

    public Player(int payment, List<Integer> numbers, int plusNumber) {
        this.payment = payment;
        this.numbers = numbers;
        this.plusNumber = plusNumber;
    }
}
