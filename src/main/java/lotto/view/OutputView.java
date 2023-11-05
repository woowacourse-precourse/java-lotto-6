package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printCountPurchaseLottoMessage(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
