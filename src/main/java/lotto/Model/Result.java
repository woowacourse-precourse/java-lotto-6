package lotto.Model;

import lotto.View.PrintOutput;

import java.util.EnumMap;

public class Result {
    private final EnumMap<Winning, Integer> result = new EnumMap<>(Winning.class);

    public Result() {
        for (Winning winning : Winning.values()) {
            result.put(winning, 0);
        }
    }

    public void winningResult(int match, int bonusBall) {
        Winning winning = Winning.result(match, bonusBall);
        result.put(winning, result.get(winning) + 1);
    }

    public void printResult(int purchasePrice) {
        int totalPrice = 0;
        System.out.println("\n" + PrintOutput.RESURLT_LOTTO + "\n---");
        for (Winning winning : Winning.values()) {
            totalPrice += winning.getWinningPrice() * result.get(winning);
            if (winning != Winning.No_Match) {
                String message = String.format(
                        "%d개 일치 (%s원) - %d개",
                        winning.getMatchNumber(),
                        String.format("%,d", winning.getWinningPrice()),
                        result.get(winning));
                if (winning == Winning.SECOND) {
                    message = message.replace("일치", "일치, 보너스 볼 일치");
                }
                System.out.println(message);
            }
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.", (double)totalPrice / purchasePrice * 100);
    }
}
