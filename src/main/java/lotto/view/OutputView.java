package lotto.view;

public class OutputView {

    public void askForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers() {

    }

    private void printLottoNumber() {

    }

    public void askForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개");
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
