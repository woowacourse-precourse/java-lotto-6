package lotto;

public class PrintOut {

    public void purchaseGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void confirmPurchase(int numberOfLottos) {
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void inputWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void getStatistics(LottoResult lottoResult, double roundedReturn) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getCount(WinningCriteria.FIFTH_PLACE) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getCount(WinningCriteria.FOURTH_PLACE) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getCount(WinningCriteria.THIRD_PLACE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +
                lottoResult.getCount(WinningCriteria.SECOND_PLACE) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getCount(WinningCriteria.FIRST_PLACE) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", roundedReturn);
    }
}
