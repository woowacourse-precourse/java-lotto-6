package lotto.domain;

import lotto.enumeration.WinningType;

import java.util.EnumMap;

public class Result {
    private final EnumMap<WinningType, Integer> result;

    public Result() {
        result = new EnumMap<>(WinningType.class);
        for(WinningType winningType : WinningType.values()) {
            result.put(winningType, 0);
        }
    }

    public void update(WinningType winningType) {
        result.put(winningType, result.get(winningType)+1);
    }

    public EnumMap<WinningType, Integer> getResult() {
        return this.result;
    }

}