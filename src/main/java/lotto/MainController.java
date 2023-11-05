package lotto;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController(new InputView());

    public MainController() {
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        int amountOfPurchasedLotto = purchaseAmount.getAmountOfPurchasedLotto();
        Lottos lottos = getLottos(amountOfPurchasedLotto);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return inputController.getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private Lottos getLottos(int amountOfPurchasedLotto) {
        List<Lotto> lottoList = LottoMaker.makeLotto(amountOfPurchasedLotto);
        return new Lottos(lottoList);
    }
}