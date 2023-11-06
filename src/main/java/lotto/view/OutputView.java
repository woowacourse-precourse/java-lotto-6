package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String[] LOTTO_PRINT_FORMAT = {"[", "]"};
    private static final String DELIMITER = ", ";

    public static void printPurchaseLottoCounts(PurchaseAmount purchaseAmount) {
        System.out.println(String.format(LOTTO_PURCHASE_COUNT_MESSAGE, purchaseAmount.getLottoCount()));
    }

    public static void printRandomLottoNumbers(PurchasedLottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto : lottos) {
            printSingleLottoNumber(lotto);
        }
    }

    private static void printSingleLottoNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String singleLotto = numbers.stream()
                .map(number -> String.format("%d", number))
                .collect(Collectors.joining(DELIMITER, LOTTO_PRINT_FORMAT[0], LOTTO_PRINT_FORMAT[1]));
        System.out.println(singleLotto);
    }
}
