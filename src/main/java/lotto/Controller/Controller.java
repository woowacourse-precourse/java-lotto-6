package lotto.Controller;

import lotto.View.View;
import lotto.domain.*;
import lotto.mapper.Mapper;
import lotto.utils.RandomLottoGenerator;

import java.util.List;

public class Controller {

    private final View view;
    private final Mapper mapper;

    public Controller() {
        this.view = new View();
        this.mapper = new Mapper();
    }

    public void start() {
        PurchaseMoney purchaseMoney = insertMoney();
        List<Lotto> userLottos = purchaseLotto(purchaseMoney);
        WinnerNumbers winnerNumbers = generateWinnerNumbers();
        BonusNumber bonusNumber = generateBonusNumber(winnerNumbers);
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

    private WinnerNumbers generateWinnerNumbers() {
        List<Integer> lottoNumbers = mapper.stringToIntegerList(view.getWinnerNumbers());
        return  new WinnerNumbers(lottoNumbers);
    }

    private BonusNumber generateBonusNumber(WinnerNumbers winnerNumbers) {
        return new BonusNumber(view.getBonusNumber(), winnerNumbers);
    }
}
