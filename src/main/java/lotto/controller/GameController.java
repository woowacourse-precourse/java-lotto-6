package lotto.controller;

import lotto.domain.PurchaseCount;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.view.GameView;

public class GameController {

    private final LottoService model;
    private final GameView view;

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        PurchaseCount purchaseCount = new PurchaseCount(view.inputLottoPurchaseAmount());
        model.issueLottos(purchaseCount.getValue());
        printLottos(purchaseCount.getValue(), model.findAllLottos());
    }

    private void printLottos(int lottoPurchaseCount, Lottos lottos) {
        view.printLottoCount(lottoPurchaseCount);
        lottos.getLottos()
                .forEach(lotto -> view.printLottoNumbers(lotto.getNumbers()));
    }

}
