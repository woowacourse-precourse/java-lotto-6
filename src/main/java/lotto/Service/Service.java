package lotto.Service;

import lotto.View.View;
import lotto.constant.ErrorMessage;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinnerNumbers;
import lotto.mapper.Mapper;
import lotto.utils.RandomLottoGenerator;

import java.io.IOException;
import java.util.List;

public class Service {
    private final View view;
    private final Mapper mapper;


    public Service() {
        this.view = new View();
        this.mapper = new Mapper();
    }

    public PurchaseMoney getPurchaseMoney() {
        try {
            return new PurchaseMoney(view.getPurchasePrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseMoney();
        }
    }

    public List<Lotto> getPurchaseLottos(Integer count) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        try {
            List<Lotto> userLottos = randomLottoGenerator.generateMultipleLotto(count);
            view.printIssuanceLotto(userLottos);
            return userLottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseLottos(count);
        }
    }

    public WinnerNumbers getWinnerNumbers() {
        try {
            List<Integer> lottoNumbers = mapper.stringToIntegerList(view.getWinnerNumbers());
            return new WinnerNumbers(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinnerNumbers();
        }
    }

    public BonusNumber getBonusNumber(WinnerNumbers winnerNumbers) {
        try {
            return new BonusNumber(view.getBonusNumber(), winnerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winnerNumbers);
        }
    }
}
