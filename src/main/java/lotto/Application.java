package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static Purchase getPurchaseAmount(GetPurchaseUI getPurchaseUI) {

        String input = getPurchaseUI.enterPurchaseAmountUI();

        return new Purchase(input);
    }

    public static void main(String[] args) {

        GetPurchaseUI getPurchaseUI = new GetPurchaseUI();
        PrintLottoUI printLottoUI = new PrintLottoUI();
        Purchase purchase;
        int lottoCount;
        List<Lotto> lottos = new ArrayList<>();

        while (true) {
            try {
                purchase = getPurchaseAmount(getPurchaseUI);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_PURCHASE_AMOUNT);
            }
        }

        lottoCount = purchase.getPurchaseAmount() / 1000;

        printLottoUI.printLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            MakeLotto makeLotto = new MakeLotto();
            lottos.add(makeLotto.makeLotto());
            printLottoUI.printLotto(lottos.get(i).getLotto());
        }

    }
}
