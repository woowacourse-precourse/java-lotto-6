package lotto.Model;

import java.util.EnumMap;

public class Result {
    private EnumMap<Winning, Integer> result = new EnumMap<>(Winning.class);

    public Result() {
        for (Winning winning : Winning.values()) {
            result.put(winning, 0);
        }
    }

    public void winningResult(int match, int bonusBall) {
        Winning winning = Winning.result(match, bonusBall);
        result.put(winning, result.get(winning) + 1);
    }

    public void printResult() {
        System.out.println("\n당첨 통계" + "\n---");
        for (Winning winning : Winning.values()) {
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
    }

}
