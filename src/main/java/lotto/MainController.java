package lotto;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController(new InputView());
    private final OutputView outputView = new OutputView();

    public MainController() {
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        int amountOfPurchasedLotto = purchaseAmount.getAmountOfPurchasedLotto();
        Lottos lottos = createLottos(amountOfPurchasedLotto);

        printPurchasedLottoAmount(amountOfPurchasedLotto);
        printPurchasedLottos(lottos);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return inputController.getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private Lottos createLottos(int amountOfPurchasedLotto) {
        List<Lotto> lottoList = LottoMaker.makeLotto(amountOfPurchasedLotto);
        return new Lottos(lottoList);
    }

    private void printPurchasedLottos(Lottos lottos) {
        List<LottoDTO> lottoDTOs = lottos.getLottoDTOs();
        outputView.printPurchasedLottos(lottoDTOs);
    }

    private void printPurchasedLottoAmount(int amountOfPurchasedLotto) {
        outputView.printPurchasedLottoAmount(amountOfPurchasedLotto);
    }
}