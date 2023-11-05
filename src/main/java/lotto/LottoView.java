package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    public static String requestPurchasePrice() {
        printConstantMessage(LottoViewConstantMessages.PURCHASE_PRICE_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.print(lottos.getLottos().size());
        printConstantMessage(LottoViewConstantMessages.PURCHASED_QUANTITY_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static String requestWinningNumbers() {
        printConstantMessage(LottoViewConstantMessages.BONUS_NUMBER_REQUEST_MESSAGE);
        String readLine = readLine();
        System.out.println();
        return readLine;
    }

    private static void printConstantMessage(LottoViewConstantMessages lottoViewConstantsMessage) {
        System.out.println(lottoViewConstantsMessage.getMessage());
    }

}
