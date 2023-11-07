package lotto.view;

import java.util.List;

import static lotto.utils.OutputViewPhrase.*;

public class OutputView {

    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt+outputPurchaseLottoCnt);
    }

    public static void printLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

}
