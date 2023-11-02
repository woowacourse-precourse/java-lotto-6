package lotto.view;

import lotto.model.CountOfCorrectLotto;
import lotto.model.Lotto;
import lotto.model.WinningDetail;

import java.text.DecimalFormat;
import java.util.List;

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
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (CountOfCorrectLotto countOfCorrectLotto : winningDetail.getCountOfCorrectLottos()) {
            System.out.println(countOfCorrectLotto.getWinningDescription() +
                    " " + "(" + decimalFormat.format(countOfCorrectLotto.getWinningPrize()) +"원" + ")" + " - " +
                    countOfCorrectLotto.getCount() + "개");
        }
    }

    public static void printTotalReturn(Double totalReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        System.out.println("총 수익률은 " + decimalFormat.format(totalReturn) + "%입니다.");
    }
}
