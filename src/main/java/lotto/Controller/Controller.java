package lotto.Controller;

import lotto.View.View;
import lotto.constant.JudgeBonus;
import lotto.constant.LottoRanking;
import lotto.domain.*;
import lotto.utils.RandomLottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Controller {

    private final View view;

    public Controller() {
        this.view = new View();
    }

    public void start() {
        PurchaseMoney purchaseMoney = insertMoney();
        List<Lotto> userLottos = purchaseLotto(purchaseMoney);
    }

    private PurchaseMoney insertMoney() {
        return new PurchaseMoney(view.getPurchasePrice());
    }

    private List<Lotto> purchaseLotto(PurchaseMoney purchaseMoney) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        List<Lotto> userLottos = randomLottoGenerator.generateMultipleLotto(purchaseMoney.getCount());
        view.printIssuanceLotto(userLottos);
        return userLottos;
    }
}
