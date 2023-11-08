package lotto.view;

import lotto.domain.result.Grade;

import java.util.List;

public class View {

    public void breakLine() {
        System.out.println();
    }

    public void askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void notifyQuantityOfPurchase(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void notifyLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void statisticsTitle() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void notifyStatistics(Grade grade, int countGrade) {
        System.out.println(grade.getCondition() + " (" + grade.getPrizeWon() + ") - " + countGrade + "개");
    }

    public void notifyEarningRate(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
