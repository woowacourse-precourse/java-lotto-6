package lotto.controller;

import lotto.domain.LottoService;
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
    }

    private int getLottoPurchaseAmount(String input){
        return Integer.parseInt(input);
    }

}
