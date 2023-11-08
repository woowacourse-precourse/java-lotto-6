package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseQuantity;
import lotto.domain.WinnerStatistics;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.OutputMessage.*;
import static lotto.util.LottoGenerator.generateLottoNumbers;

public class OutputView {

    public static void announcePurchaseQuantity(PurchaseQuantity purchaseQuantity) {
        printObject(ANNOUNCE_PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
        lineBreak();
    }

    public static Lottos getIssuedLottos(PurchaseQuantity quantity) {
        List<Lotto> lottos = new ArrayList<>();
        quantity.forEach((repeat) -> lottos.add(new Lotto(generateLottoNumbers())));
        return new Lottos(lottos);
    }

    public static void showIssuedLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach((lotto) -> printObjectWithLine(lotto));
    }

    private static void printObjectWithLine(Lotto lotto) {
        printObject(lotto);
        lineBreak();
    }

    public static void printObject(OutputMessage outputMessage, Object object) {
        System.out.print(String.format(outputMessage.getMessage(), object.toString()));
    }

    public static void announceWinningStatistics(WinnerStatistics winnerStatistics) {
        System.out.println(ANNOUNCE_WINNING_STATISTICS_START.getMessage());
        System.out.println(DIVISION_LINE.getMessage());
        printObject(winnerStatistics);
    }

    public static void printObject(Object object) {
        System.out.print(object.toString());
    }

    public static void lineBreak() {
        System.out.println();
    }
}
