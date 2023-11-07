package lotto.view.output;

import lotto.model.Lotto;

import java.util.ArrayList;

public class OutputView {
    OutputMaker outputMaker = new OutputMaker();
    public void showPurchasedLotto(int purchasedLottoCount, ArrayList<Lotto> purchasedLotto) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            String lottoNumber = outputMaker.lottoNumberCheckMaker(lotto.getNumbers());
            System.out.println(lottoNumber);
        }
        generateBlank();
    }

    public void WinningGradeVisualization(int[] winningGrade, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        String winningGradeVisualization = outputMaker.visualizeWinningGrade(winningGrade);
        System.out.println(winningGradeVisualization);
        String profitMessage = outputMaker.makeProfitMessage(profitRate);
        System.out.println(profitMessage);
    }

    public void generateBlank() {
        System.out.println();
    }
}
