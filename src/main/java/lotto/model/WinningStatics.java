package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatics {

    private final Map<WinningGrade, Integer> statics;

    public WinningStatics() {
        this.statics = initStatics();
    }

    public Map<WinningGrade, Integer> initStatics() {
        return Arrays.stream(WinningGrade.values())
                .collect(Collectors.toMap(
                        grade -> grade,
                        grade -> 0,
                        (a, b) -> a,
                        () -> new EnumMap<>(WinningGrade.class)));
    }

    public void addWinningCount(final WinningGrade winningGrade) {
        this.statics.put(
                winningGrade,
                statics.get(winningGrade) + 1);
    }

    public Map<WinningGrade, Integer> getStatics() {
        return statics;
    }

}
