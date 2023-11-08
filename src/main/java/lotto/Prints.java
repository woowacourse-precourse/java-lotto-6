package lotto;

public class Prints {
    public static void printResult(LottoResultChecker lottoResultChecker) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResultChecker.ranks[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResultChecker.ranks[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResultChecker.ranks[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResultChecker.ranks[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResultChecker.ranks[1]);
        System.out.println("총 수익률은 " + lottoResultChecker.returnRatio + "%입니다.");
    }
}
