package lotto.controller;

import lotto.model.Lotto;
import lotto.service.Service;

import java.util.HashMap;
import java.util.List;

public class Controller {
    private final Service service = new Service();
    public List<Lotto> buyLotteries(int price) {
        return service.buyLotteries(price);
    }

    public HashMap<String, Integer> getLotteryResult(List<Lotto> boughtLotteries, Lotto winner, int bonusNumber) {
        return service.getLotteryResult(boughtLotteries, winner, bonusNumber);
    }
}
