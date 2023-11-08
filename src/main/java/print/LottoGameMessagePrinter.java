package print;

import java.util.List;
import lotto.Lotto;
import lottorank.LottoRank;
import validate.Validator;

public abstract class LottoGameMessagePrinter {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void lottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void InputBuyLottoTicketMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    public static void InputWinningNumber() {
        printMessage("당첨 번호를 입력해 주세요.");
    }
    public static void InputBonusNumber() {
        printMessage("보너스 번호를 입력해 주세요.");
    }
    public static void printResultMessage() {
        printMessage("당첨 통계");
        printMessage("---");
    }

    public static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            Validator.validate(lotto.getNumbers());
            lottoNumbers(lotto.getNumbers());
        }
    }
    public static void printPurchasedTickets(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
    }
    // LottoGameMessagePrinter 클래스 내의 메서드
    public static void printResult(int[] winCounts, int totalSpent) {
        int totalWin = 0; // 총 당첨금 계산을 위한 변수

        for (LottoRank rank : LottoRank.values()) {
            int count = winCounts[rank.ordinal()];
            totalWin += count * rank.getPrizeMoney();

            String bonusMatchString = "";
            if (rank.isBonusMatch()) {
                bonusMatchString = ", 보너스 볼 일치";
            }

            System.out.printf("%d개 일치%s (%s원) - %d개\n",
                    rank.getMatchCount(), bonusMatchString, formatPrizeMoney(rank.getPrizeMoney()), count);
        }
        double profitRate = ((double) totalWin / totalSpent) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static String formatPrizeMoney(int prizeMoney) {
        return String.format("%,d", prizeMoney);
    }

}

