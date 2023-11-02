package lotto.view;

import lotto.model.CountOfCorrectLotto;
import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.model.WinningDetail;

import java.util.List;
import java.util.Map;

public class Printer {
    public static void printWhiteSpace() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printInputLottoPurchasePayment() {
        System.out.println("구입금액을 입력해 주세요.");
    }


    public static void printLottos(List<Lotto> lottos) {
        printWhiteSpace();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printInputWinningNumbers() {
        printWhiteSpace();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumber() {
        printWhiteSpace();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningDetail(WinningDetail winningDetail) {
        for (CountOfCorrectLotto countOfCorrectLotto : winningDetail.getCountOfCorrectLottos()) {
            System.out.println(countOfCorrectLotto.getWinningDescription() +
                    " " + "(" + countOfCorrectLotto.getWinningPrice() + ")" + " - " +
                    countOfCorrectLotto.getCount() + "개");
        }
    }
}
