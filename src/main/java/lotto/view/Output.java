package lotto.view;

import lotto.domain.Rank;

import java.util.Collections;
import java.util.List;

public class Output {
    public static final String ERROR_RANDOM_MACHINE = "잘못된 랜덤 생성입니다.";
    //private static final String MESSAGE_EARNING_RATE = String.format("총 수익률은 d%입니다.",earningRate);
    public static final String MESSAGE_EARNING_RATE = "총 수익률은 %.1f%%입니다.";
    public static final String MESSAGE_RANKING_LIST_COUNT = "%d개 일치";
    public static final String MESSAGE_RANKING_LIST_COUNT_SECOND = ", 보너스 볼 일치";
    public static final String MESSAGE_PRIZE = " (%s원) ";
    public static final String MESSAGE_MATCH_RESULT = "- %d개";


    public static void printErrorMessage(String error) {
        System.out.println("[ERROR] " + error);
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printPurchasedLottoList(List<Integer> lotto) {
        Collections.sort(lotto);
        System.out.println(lotto);

    }

    public static void printResultRanking(double earningRate) {
        String.format("%.1f", earningRate);
        String MSG = String.format(MESSAGE_EARNING_RATE,earningRate);
        System.out.println(MSG);

    }

    public static void printEarningRate(int matchCount, int prizeMoney, int matchedResult) {
        String prizeMoneyFormatted = String.format("%,d", prizeMoney);
        String COUNT = String.format(MESSAGE_RANKING_LIST_COUNT, matchCount);
        String PRIZE = String.format(MESSAGE_PRIZE, prizeMoneyFormatted);
        String MATCHRESULT = String.format(MESSAGE_MATCH_RESULT, matchedResult);

        if (prizeMoney == Rank.SECOND.getPrizeMoney()) {
            COUNT += MESSAGE_RANKING_LIST_COUNT_SECOND;
        }
        System.out.println(COUNT + PRIZE + MATCHRESULT);

    }


}
