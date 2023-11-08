package lotto.result;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.Grade;


import static lotto.util.Constant.DEFAULT_VALUE;

public class Result {

    private final Map<Grade, Integer> result;

    public Result() {
        this.result = new HashMap<>();
    }

    public void addResult(Grade grade) {
        this.result.put(grade, this.result.getOrDefault(grade, DEFAULT_VALUE) + 1);
    }

    public Map<Grade, Integer> getMap() {
        return Collections.unmodifiableMap(this.result);
    }
}
