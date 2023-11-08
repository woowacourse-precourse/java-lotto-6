package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutputView {
    public void printInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseLottoesMessage(List<Lotto> lottoes) {
        System.out.println();
        System.out.println(lottoes.size() + "개를 구매했습니다.");
        for (Lotto currentLotto : lottoes) {
            System.out.println(currentLotto.getNumbers());
        }
    }

    public void printInputWinningLottoNumberMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputWinningBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoesResult(Map<Integer, Integer> lottoesResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoesResult.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoesResult.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoesResult.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoesResult.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoesResult.get(1) + "개");
    }
}
