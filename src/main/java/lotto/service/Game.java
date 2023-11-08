package lotto.service;

import lotto.controller.Controller;

public class Game {
    private Controller controller;

    public Game() {
        controller = new Controller(this);
    }

    public void run() {
        controller.createLotto();
    }
}
