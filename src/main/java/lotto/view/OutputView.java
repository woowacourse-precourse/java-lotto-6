package lotto.view;

import lotto.dto.LottoNumbers;
import lotto.dto.PurchasedLotto;

import java.util.List;

public class OutputView {

    public static void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        int purchasesNumber = purchasedLotto.purchasesNumber();
        printLineSeparator();
        System.out.printf("%d개를 구매했습니다.", purchasesNumber);
        printLineSeparator();

        List<LottoNumbers> lottos = purchasedLotto.lottos();
        lottos.forEach(lottoNumbers -> System.out.println(lottoNumbers.displayNumbers()));
    }

    private static void printLineSeparator() {
        System.out.println();
    }
}
