package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.InputService;

public class GameController {

    InputService inputService = new InputService();
    public void init() {
        System.out.println(inputService.readPurchaseAMount());
    }
}
