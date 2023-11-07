package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HitNumbers {
    private final List<Integer> hitNumbers;

    public HitNumbers(List<Integer> hitNumbers) {
        this.hitNumbers = new ArrayList<>(hitNumbers);
    }

    public List<Integer> getHitNumbers() {
        return Collections.unmodifiableList(hitNumbers);
    }

    public boolean findNumber(int number) {
        return hitNumbers.contains(number);
    }
}
