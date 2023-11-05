package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoView {

    public void printGap() {
        System.out.println();
    }

    public void userCountInputAnnouncement() {
        printGap();
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumberAnnouncement(int numberOfLotto) {
        printGap();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public void userLottoBonusNumberAnnouncement() {
        printGap();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void userInputLottoWinningNumberAnnouncement() {
        printGap();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void totalResultAnnouncement() {
        printGap();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printLottoNumber(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage + " 다시 입력해주세요.");
    }

    public void printEachPrice(ArrayList<Integer> winningCount) {
        System.out.println("3개 일치 (5,000원) - " + winningCount.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount.get(0) + "개");
    }

    public void printWinningRate(BigDecimal winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

}
