package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public void printPayAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String inputValue() {
        return Console.readLine();
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseLottoAmount(int purchasedLottoAmount) {
        System.out.println();
        System.out.println(purchasedLottoAmount + "개를 구매했습니다.");
    }

    public void printIssuedLotto(String lotto) {
        System.out.println(lotto);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoResult(List<Integer> lottoResult) {
        System.out.println();
        System.out.printf("당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - %d개\n"
                + "4개 일치 (50,000원) - %d개\n"
                + "5개 일치 (1,500,000원) - %d개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                + "6개 일치 (2,000,000,000원) - %d개\n",lottoResult.get(5),lottoResult.get(4),lottoResult.get(3),
                lottoResult.get(2),lottoResult.get(1));
    }
}
