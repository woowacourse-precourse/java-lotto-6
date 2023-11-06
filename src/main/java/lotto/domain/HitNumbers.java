package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HitNumbers {
    private final List<Integer> hitNumbers;

    public HitNumbers(List<Integer> hitNumbers) {
        this.hitNumbers = hitNumbers;
    }

    public Collection<Integer> getHitNumbers() {
        return Collections.unmodifiableCollection(hitNumbers);
    }
}
