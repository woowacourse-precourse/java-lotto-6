package view;

import java.util.List;

public class Output {

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printWinNums(List<Integer> winNums) {
        System.out.println(winNums);
    }

    public static void printResul(int[] prizeRank, double rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeRank[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeRank[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeRank[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                prizeRank[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeRank[6]);
        System.out.printf("총 수익률은 %.1f", rate);
        System.out.print("%입니다.");
    }


}
