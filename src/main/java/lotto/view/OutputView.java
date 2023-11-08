package lotto.view;

import java.util.HashMap;
import lotto.constants.WinningCondition;
import lotto.model.Lotto;

public class OutputView {

    public void printPaymentInstruction() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseAmount(int amountOfLotto) {
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printWinningNumberInstruction() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInstruction() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatisticsInstruction(HashMap<String, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(WinningCondition.FIFTH_PLACE.getMessage() + " - " + result.get("5등") + "개");
        System.out.println(WinningCondition.FORTH_PLACE.getMessage() + " - " + result.get("4등") + "개");
        System.out.println(WinningCondition.THIRD_PLACE.getMessage() + " - " + result.get("3등") + "개");
        System.out.println(WinningCondition.SECOND_PLACE.getMessage() + " - " + result.get("2등") + "개");
        System.out.println(WinningCondition.FIRST_PLACE.getMessage() + " - " + result.get("1등") + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
