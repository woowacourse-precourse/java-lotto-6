package lotto.controller;

import lotto.manager.PublishManager;

public class NumberGenerateController {

    private final PublishManager publishManager = PublishManager.getInstance();

    public void handle() {
        publishManager.generateLottos();
        publishManager.printLottoList();
    }
}
