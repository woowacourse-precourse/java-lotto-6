package lotto.lottoUI;

public class LottoUI {
    public static void InputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void InputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void DisplayOfLottoNumber(int LottoNumber) {
        System.out.println(LottoNumber + "개를 구매했습니다.");
    }

    public static void InputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void DisplayWinningStatistics() {
        System.out.println("당첨 통계\n---");
    }

    public static void DisplayNumberOfMatches(String Description, int count) {
        System.out.printf("%s - %d개\n", Description, count);
    }

    public static void DisplayRateOfReturn(double earningRate){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}