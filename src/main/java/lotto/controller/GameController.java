package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoSeller;
import lotto.view.InputView;

import java.util.ArrayList;

public class GameController {

    private static GameController gameController;

    private final InputView inputView;
    private final LottoSeller lottoSeller;

    private GameController(InputView inputView) {
        this.inputView = inputView;
        lottoSeller = new LottoSeller();
    }

    public static GameController getInstance(InputView inputView) {
        if (gameController == null) {
            gameController = new GameController(inputView);
        }
        return gameController;
    }

    public void startGame() {
        int amount = inputView.readAmount();
        ArrayList<Lotto> lottoBundle = lottoSeller.sellLotto(amount);
    }
}
