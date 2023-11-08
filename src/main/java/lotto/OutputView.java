package lotto;

public class OutputView {
    static void outputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    static void outputNumberOfPurchases(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }
    
    static void outputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    
    static void outputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    
    static void outputStartWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    
    static void outputWinnintStatistics(int[] rank) {
        System.out.println("3개 일치 (5,000원) - " + rank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank[1] + "개");
    }
    
    static void outputRateOfReturn(double number) {
        System.out.println("총 수익률은 " + String.format("%.1f", number) + "%입니다.");
    }
}
