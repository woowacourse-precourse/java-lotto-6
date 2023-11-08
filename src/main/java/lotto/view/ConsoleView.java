package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPlayer;
import lotto.domain.LottoPrize;
import lotto.domain.Referee;
import lotto.util.Message;

public class ConsoleView {

    public static void printInputPurchaseAmountMessage() {
        System.out.println(Message.inputPurchaseAmount);
    }

    public static void printPurchaseConfirmationMessage(int n) {
        System.out.println(n + Message.purchaseConfirmation);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(Message.inputWinningNumbers);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(Message.inputBonusNumber);
    }

    public static void printLottos(Lotto[] lottos) {

        for (Lotto lotto: lottos) {
            StringBuilder sb = new StringBuilder();
            System.out.print("[");
            for (int number: lotto.getNumbers()) {
                sb.append(number).append(", ");
            }
            System.out.print(sb.substring(0, sb.length() - 2));
            System.out.println("]");
        }
    }

    public static void printResult(LottoPlayer lottoPlayer, Referee referee) {
        System.out.println(Message.winningStatistics);

        StringBuilder sb = new StringBuilder();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            int count = referee.countLottosWithMatches(lottoPlayer.getLottos(), lottoPrize);
            sb.append(lottoPrize.getMessage()).append(" - ").append(count).append("개\n");
            lottoPlayer.addProfit(count * lottoPrize.getPrizeMoney());
        }

        System.out.print(sb);

        printYieldRateOfReturn(lottoPlayer.getProfit(), lottoPlayer.getPurchaseAmount());
    }

    private static void printYieldRateOfReturn(int profit, int purchaseAmount) {
        double yieldRateOfReturn = (double) profit / purchaseAmount * 100.0;
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", yieldRateOfReturn);
    }

    public static void printLine() {
        System.out.println();
    }
}
