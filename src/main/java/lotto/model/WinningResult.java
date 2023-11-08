package lotto.model;

import java.util.Arrays;

public enum WinningResult {

    FIFTH("3개 일치 (5,000원) - %d개", 0, 3, false, 5000),
    FOURTH("4개 일치 (50,000원) - %d개", 0, 4, false, 50000),
    THIRD("5개 일치 (1,500,000원) - %d개", 0, 5, false, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 0, 5, true, 30000000),
    FIRST("6개 일치 (2,000,000,000원) - %d개", 0, 6, false, 2000000000);

    private final String message;
    private int countResult;
    private final int matchCount;
    private final boolean matchBonus;
    private final int price;

    WinningResult(String message, int countResult, int matchCount, boolean matchBonus, int price) {
        this.message = message;
        this.countResult = countResult;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static void countLottoResult(int correctCnt, boolean correctBonus) {
        Arrays.stream(WinningResult.values())
                .filter(value -> value.matchCount == correctCnt && value.matchBonus == correctBonus)
                .forEach(value -> value.countResult++);
    }

    public static void showResult() {
        Arrays.stream(WinningResult.values())
                .map(value -> String.format(value.message, value.countResult))
                .forEach(System.out::println);
    }

    public static int calculateTotalPrice() {
        int totalPrice = Arrays.stream(WinningResult.values())
                .map(value -> value.countResult * value.price)
                .reduce(0, Integer::sum);

        return totalPrice;
    }
}
