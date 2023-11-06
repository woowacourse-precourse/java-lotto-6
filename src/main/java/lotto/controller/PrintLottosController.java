package lotto.controller;

import lotto.service.Service;

import java.util.Map;

public class PrintLottosController implements BasicController {
    private final Service service = new Service();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        service.printLottos();
        return "printWinningResult";
    }
}
