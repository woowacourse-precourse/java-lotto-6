package lotto.view;

import java.util.List;
import lotto.model.Rank;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printNumOfTickets(long numOfTickets) {
        System.out.println("\n" + numOfTickets + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }

    public static void printWinningLottosInfo(Rank rank, long cnt) {
        System.out.println(rank.getMessage() + " - " + cnt + "개");
    }

    public static void printGainPercentage(double gainPercentage) {
        System.out.println("총 수익률은 " + gainPercentage + "%입니다.");
    }
}
