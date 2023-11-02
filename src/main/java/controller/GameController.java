package controller;

import resolver.InputResolver;

public class GameController {
    private final InputResolver inputResolver;

    public GameController(InputResolver inputResolver) {
        this.inputResolver = inputResolver;
    }

    public void game(){
        int lottoPurchasePrice = inputResolver.preprocessLottoPurchasePrice();
    }
}
