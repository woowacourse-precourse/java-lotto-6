package lotto.View;

import lotto.Domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottosSize(int size) {
        System.out.println(String.format("%d개를 구매했습니다.", size));
    }

    public static void printLottosNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printRankCount(Map<Rank, Integer> rankCount) {
        printRank(Rank.FIFTH, "5,000", rankCount);
        printRank(Rank.FOURTH, "50,000", rankCount);
        printRank(Rank.THIRD, "1,500,000", rankCount);
        printSecondRank(Rank.SECOND, "30,000,000", rankCount);
        printRank(Rank.FIRST, "2,000,000,000", rankCount);
    }

    public static void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    private static void printRank(Rank rank, String prize, Map<Rank, Integer> rankCount) {
        int count = rankCount.getOrDefault(rank, 0);
        System.out.println(rank.getMatchedNumbers() + "개 일치 (" + prize + "원) - " + count + "개");
    }

    private static void printSecondRank(Rank rank, String prize, Map<Rank, Integer> rankCount) {
        int count = rankCount.getOrDefault(rank, 0);
        System.out.println(
            rank.getMatchedNumbers() + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개");
    }
}
