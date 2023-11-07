package lotto.Model;

import lotto.DTO.Result;
import lotto.View.PrintOutput;

public class LottoResult {
    private final Result result;

    public LottoResult(Result result){
        this.result = result;
    }

    public void printResult(int purchasePrice) {
        int totalPrice = 0;
        System.out.println("\n" + PrintOutput.RESURLT_LOTTO + "\n---");

        for (Winning winning : Winning.values()) {
            totalPrice += winning.getWinningPrice() * result.getCountLottoResult(winning);
            printMatch(winning);
        }

        System.out.printf("총 수익률은 %,.1f%%입니다.", (double) totalPrice / purchasePrice * 100);
    }

    private void printMatch(Winning winning) {
        String message = String.format(
                "%d개 일치 (%s원) - %d개",
                winning.getMatchNumber(),
                String.format("%,d", winning.getWinningPrice()),
                result.getCountLottoResult(winning));

        if (winning != Winning.No_Match) {
            if (winning == Winning.SECOND) {
                message = message.replace("일치", "일치, 보너스 볼 일치");
            }
            System.out.println(message);
        }

    }
}