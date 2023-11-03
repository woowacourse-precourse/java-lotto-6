package lotto.view;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    /**
     * 줄 바꿈
     */
    public static void newLineOutput() {
        System.out.println();
    }

    /**
     * 구입 금액 입력
     */
    public static void amountOutput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /**
     * 로또 구입 갯수
     *
     * @param quantity
     */
    public static void lottoBuyQuantityOutput(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    /**
     * 로또 정보
     *
     * @param lottoNumber
     */
    public static void lottoNumberOutput(String lottoNumber) {
        System.out.println(lottoNumber);
    }

    /**
     * 로또 당첨 번호
     */
    public static void winLottoNumberOutput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    /**
     * 보너스 당첨 번호
     */
    public static void bonusLottoNumberOutput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    /**
     * 당첨 통계
     */
    public static void lottoResultOutput(List<Integer> prizeResults, String profitRate) {
        System.out.println("당첨 통계");
        System.out.println("----");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeResults.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeResults.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeResults.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeResults.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeResults.get(0));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    /**
     * 예외
     *
     * @param message
     */
    public static void errorMessageOutput(String message) {
        System.out.println(message);
    }
}
