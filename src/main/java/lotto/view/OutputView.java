package lotto.view;

public class OutputView {
    public void printLotties(String lottiesStatus, int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        System.out.println(lottiesStatus);
    }

    public void printGameResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }
}
