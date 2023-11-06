package lotto.controller;

import lotto.service.InputService;

public class GameController {
    InputService inputService;

    public GameController(){
        inputService = new InputService();
    }

}
