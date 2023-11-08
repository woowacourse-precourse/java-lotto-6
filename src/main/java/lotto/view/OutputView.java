package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.OutputMessage.*;
import static lotto.util.LottoGenerator.generateLottoNumbers;

public class OutputView {

    public static Lottos announceIssuedLottos(PurchaseQuantity quantity) {
        announcePurchaseQuantity(quantity);
        return showIssuedLottos(quantity);
    }

    public static void announcePurchaseQuantity(PurchaseQuantity purchaseQuantity) {
        printObject(ANNOUNCE_PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
        lineBreak();
    }

    private static Lottos showIssuedLottos(PurchaseQuantity quantity) {
        List<Lotto> lottos = new ArrayList<>();
        quantity.forEach((repeat) -> {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottos.add(lotto);

            printObject(lotto);
            lineBreak();
        });

        return new Lottos(lottos);
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
