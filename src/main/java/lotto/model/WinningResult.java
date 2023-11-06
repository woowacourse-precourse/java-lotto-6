package lotto.model;

import java.util.List;

public enum WinningResult {

    THREE_WINNING("3개 일치 (5,000원) - %d개", 3, false, 0, 5000),
    FOUR_WINNING("4개 일치 (50,000원) - %d개", 4, false, 0, 50000),
    FIVE_WINNING("5개 일치 (1,500,000원) - %d개", 5, false, 0, 1500000),
    SIX_WINNING_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 6, true, 0, 30000000),
    SIX_WINNING("6개 일치 (2,000,000,000원) - %d개", 6, false, 0, 2000000000);

    private final String message;
    private final int correctCond;
    private final boolean isBonus;
    private int winningCount;
    private final int money;

    WinningResult(String message, int correctCount, boolean isBonus, int winningCount, int money) {
        this.message = message;
        this.correctCond = correctCount;
        this.isBonus = isBonus;
        this.winningCount = winningCount;
        this.money = money;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public static void printWinningResult() {
        for (WinningResult value : WinningResult.values()) {
            String result = String.format(value.message, value.winningCount);
            System.out.println(result);
        }
    }

    public static void checkWinning(int bonus, List<Integer> winningNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            compareLotto(bonus, winningNumber, lotto.getNumbers());
        }
    }

    private static void compareLotto(int bonus, List<Integer> winningNumber, List<Integer> lotto) {
        boolean isBonus = false;
        int winningCount = (int) lotto.stream()
                .filter(winningNumber::contains)
                .count();

        if (lotto.contains(bonus)) {
            isBonus = true;
            winningCount++;
        }

        resultWinning(winningCount, isBonus);
    }

    private static void resultWinning(int winningCount, boolean isBonus) {
        for (WinningResult value : WinningResult.values()) {
            if (value.correctCond == winningCount && isBonus == value.isBonus) {
                value.winningCount++;
            }
        }
    }

}
