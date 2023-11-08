package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.text.NumberFormat;
import lotto.domain.Lotto;
import lotto.domain.LottoReceipt;
import lotto.domain.Rank;

public class Output {
    public static final String MESSAGE_NUMBER_OF_LOTTO_PURCHASED = "%d개를 구매했습니다.";
    public static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";
    public static final String MESSAGE_LOTTO_WINNING_STATICS = "당첨 통계";
    public static final String LINE = "---";
    public static final String MESSAGE_ERROR = "[ERROR]";

    public static void printLottoReceipt(LottoReceipt lottoReceipt) {
        List<Lotto> lottoTickets = lottoReceipt.getLottoTickets();
        System.out.println();
        System.out.printf((MESSAGE_NUMBER_OF_LOTTO_PURCHASED) + "%n", lottoTickets.size());
        lottoTickets.forEach(System.out::println);
    }

    public static void printLottoWinningResults(LottoReceipt lottoReceipt) {
        Map<Rank, Integer> result = lottoReceipt.getWinningStatistics();
        System.out.println();
        System.out.println(MESSAGE_LOTTO_WINNING_STATICS);
        System.out.println(LINE);
        List<Rank> ranks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank r : ranks) {
            printResultComment(r.getMatchingCount(), r.getPrizeMoney(), result.get(r));
        }

    }

    public static boolean printResultComment(int matchingCount, long prizeMoney, int count) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        String formattedNumber = numberFormat.format(prizeMoney);

        if (prizeMoney == 30_000_000) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + formattedNumber + "원) - " + count + "개");
            return true;
        }
        System.out.println(matchingCount + "개 일치 (" + formattedNumber + "원) - " + count + "개");
        return true;
    }

    public static void printProfitRate(Double rate) {
        System.out.printf((MESSAGE_PROFIT_RATE) + "%n", rate);
    }

    public static void printErrorMessage(String comment) {
        System.out.println(MESSAGE_ERROR + comment);
    }
}
