package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {
    public int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value){
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("숫자는 1부터 45까지만 가능합니다.");
        }
    }

    public boolean isContainedIn(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(value);
    }
}
