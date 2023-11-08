package lotto.view.output;

import lotto.model.Lotto;

import java.util.ArrayList;

public class OutputView {
    OutputMaker outputMaker = new OutputMaker();

    public void printPurchasedLotto(int purchasedLottoCount, ArrayList<Lotto> purchasedLotto) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            String lottoNumber = outputMaker.lottoNumberCheckMaker(lotto.getNumbers());
            System.out.println(lottoNumber);
        }
        generateBlank();
    }

    public void printLottoGameResult(int[] winningData, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        String winningDataVisualization = outputMaker.visualizeWinningData(winningData);
        System.out.println(winningDataVisualization);
        String profitMessage = outputMaker.makeProfitMessage(profitRate);
        System.out.println(profitMessage);
    }

    public void generateBlank() {
        System.out.println();
    }
}
