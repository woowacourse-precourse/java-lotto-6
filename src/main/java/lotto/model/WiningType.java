package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WiningType {
    ONE("1등", 6, false, 2000000000),
    TWO("2등", 5, true, 30000000),
    THREE("3등", 5, false, 1500000),
    FOUR("4등", 4, false, 50000),
    FIVE("5등", 3, false, 5000);

    private String name;
    private int correctCount;
    private boolean hasBonus;
    private int amount;

    WiningType(String name, int correctCount, boolean hasBonus, int amount) {
        this.name = name;
        this.correctCount = correctCount;
        this.hasBonus = hasBonus;
        this.amount = amount;
    }

    public static Optional<WiningType> findByWiningType(int correctCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(winingType -> winingType.isCorrectCount(correctCount) && winingType.hasBonus == hasBonus)
                .findFirst();
    }

    public static long sumAmount(Map<WiningType, Integer> winingCountMap) {
        long totAmount = 0;
        for (WiningType winingType : winingCountMap.keySet()) {
            totAmount += winingCountMap.getOrDefault(winingType, 0) * winingType.amount;
        }
        return totAmount;
    }

    public static Map<WiningType, Integer> winingCountToMap() {
        return Stream.of(values())
                .collect(Collectors.toMap(winingType -> winingType, winingType -> 0));
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getAmount() {
        return amount;
    }

    private boolean isCorrectCount(int correctCount) {
        return this.correctCount == correctCount;
    }
}

/*
 *
 * */