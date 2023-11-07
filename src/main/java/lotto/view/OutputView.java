package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.OutputViewPhrase.*;

public class OutputView {

    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt+outputPurchaseLottoCnt);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

}
