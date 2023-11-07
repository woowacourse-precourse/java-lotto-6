package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> number;


    public Lotto(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
