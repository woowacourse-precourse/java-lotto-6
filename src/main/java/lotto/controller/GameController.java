package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.PurchaseAmount;
import lotto.view.GameView;

public class GameController {

    private final LottoService model;
    private final GameView view;

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        int lottoPurchaseAmount = getLottoPurchaseAmount(view.inputLottoPurchaseAmount());
        System.out.println(lottoPurchaseAmount);
        PurchaseAmount purchaseAmount = new PurchaseAmount(lottoPurchaseAmount);
        System.out.println(purchaseAmount.getAmount());
    }

    private int getLottoPurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
