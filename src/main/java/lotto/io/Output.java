package lotto.io;

import static lotto.Play.profitCalculation;

import java.util.List;

public class Output {
    public static void printResult(List<Integer> alignRanking) {
        String s1 = String.format("3개 일치 (5,000원) - %s개", alignRanking.get(4));
        System.out.println(s1);
        String s2 = String.format("4개 일치 (50,000원) - %s개", alignRanking.get(3));
        System.out.println(s2);
        String s3 = String.format("5개 일치 (1,500,000원) - %s개", alignRanking.get(2));
        System.out.println(s3);
        String s4 = String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개", alignRanking.get(1));
        System.out.println(s4);
        String s5 = String.format("6개 일치 (2,000,000,000원) - %s개", alignRanking.get(0));
        System.out.println(s5);
        String s6 = String.format("총 수익률은 %s%%입니다.", profitCalculation(alignRanking));
        System.out.println(s6);
    }
}
