package lotto.utility.model;

import lotto.model.Game;

public enum GameFactory {
    GAME_1(10000)
    ;

    private final int cost;

    GameFactory(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public Game getInstance() {
        return new Game(cost);
    }
}
