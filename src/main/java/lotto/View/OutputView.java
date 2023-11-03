package lotto.View;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public void displayPurchaseGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void displayLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            stringBuilder.append(lotto.getNumbers()).append("\n");
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void displayWinningNumberGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void displayBonusNumberGuide() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
    }

    public void displayWinningStatisticsGuide() {
        stringBuilder.append("\n").append("당첨 통계").append("\n").append("---").append("\n");
    }

    public void displayWinningStatistics(int[] lottoResultCount) {
        stringBuilder.append("3개 일치 (5,000원) - ").append(lottoResultCount[0]).append("개").append("\n");
        stringBuilder.append("4개 일치 (50,000원) - ").append(lottoResultCount[1]).append("개").append("\n");
        stringBuilder.append("5개 일치 (1,500,000원) - ").append(lottoResultCount[2]).append("개").append("\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(lottoResultCount[3]).append("개").append("\n");
        stringBuilder.append("6개 일치 (2,000,000,000원) - ").append(lottoResultCount[4]).append("개").append("\n");
    }

    public void displayYield(double yield) {
        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", yield)).append("%").append("입니다.");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}
