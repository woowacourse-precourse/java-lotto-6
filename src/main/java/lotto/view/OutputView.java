package lotto.view;

import java.util.List;
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
}
