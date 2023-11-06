package lotto.controller;

import lotto.service.Service;

import java.util.Map;

public class GetNumberOfLottosController implements BasicController {
    private final Service service = new Service();


    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        int numberOfLotto = service.getNumberOfLottos();
        model.put("numberOfLotto", numberOfLotto);
        return "printLottos";
    }
}
