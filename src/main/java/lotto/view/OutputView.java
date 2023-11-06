package lotto.view;

import lotto.domain.WinResult;

import java.util.List;

public class OutputView {
    public void printMoneyInputGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoAmountMessage(int lottoAmount) {

    }

    public void printUserLottos(List<Integer> userLotto) {

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

    }

    public void printProfit(double profit) {

    }
}
