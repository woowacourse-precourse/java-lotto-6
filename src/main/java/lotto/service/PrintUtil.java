package lotto.service;


public class PrintUtil {

    public void printPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }
    public void printLottoNumbers(StringBuilder output) {
        System.out.println(output);
    }

    public void printWinnerNumbersInput() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberInput() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void printWinnerStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printProfit(String totalProfit) {
        System.out.print("총 수익률은 " + totalProfit + "%입니다.");
    }
}
