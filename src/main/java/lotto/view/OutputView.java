package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void printRequestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequestWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
    }


    public void printNumberOfLottosPurchased(int numberOfLottos) {
        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
