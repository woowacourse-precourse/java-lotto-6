package lotto.result;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.Grade;

import static lotto.util.Constant.DEFAULT_VALUE;

public class Result {

    private final Map<Grade, Integer> resultMap;

    public Result() {
        this.resultMap = new HashMap<>();
    }

    public void addResult(Grade grade) {
        this.resultMap.put(grade, this.resultMap.getOrDefault(grade, DEFAULT_VALUE) + 1);
    }

    public Map<Grade, Integer> getMap() {
        return Collections.unmodifiableMap(this.resultMap);
    }
}
