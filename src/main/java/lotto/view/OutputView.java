package lotto.view;

import lotto.domain.WinResult;
import lotto.util.WinnerRank;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    public void printMoneyInputGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoAmount(int lottoAmount) {
        System.out.printf("%d개를 구매했습니다.", lottoAmount);
    }

    public void printUserLottos(int lottoAmount, List<Integer> userLotto) {
        while (lottoAmount > 0) {
            System.out.println(userLotto.toString());
            lottoAmount--;
        }
    }

    public void printWinLottoNumbersInputGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumbersInputGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningResultGuideMessage() {
        System.out.println("당첨 통계\n" + "---");
    }

    public void printWinResult(WinResult winResult) {
        for(WinnerRank winnerRank : WinnerRank.values()){
            int key = winnerRank.getValue();
            System.out.printf("%d 개 일치 (%s원) - %d개\n",
                    winnerRank.getSameNumberCount(),
                    formatNumberWithCommas(winnerRank.getPrizeMoney()),
                    winResult.getWinResultValue(key));
        }
    }

    private static String formatNumberWithCommas(int winMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String winMoneyComma = numberFormat.format(winMoney);

        return winMoneyComma;
    }

    public void printProfit(double profit) {

    }
}
