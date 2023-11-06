package lotto;

public class OutputView {
    void outputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    void outputNumberOfPurchases(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }
    
    void outputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    
    void outputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    
    void outputStartWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
