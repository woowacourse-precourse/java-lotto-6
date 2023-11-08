package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.Discriminator;
import lotto.service.Inputter;
import lotto.service.LottoNumberGenerator;
import lotto.service.Printer;
import lotto.dto.LottoNumberDTO;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Pocket;
import lotto.constant.CommonUnits;

public class GameController {
    private Pocket pocket;
    private Inputter inputter;
    private Printer printer;
    private Discriminator discriminator;
    private LottoNumberGenerator lottoNumberGenerator;
    private Money money;

    public GameController(Inputter inputter, Printer printer, Discriminator discriminator,
            LottoNumberGenerator lottoNumberGenerator) {
        this.inputter = inputter;
        this.printer = printer;
        this.discriminator = discriminator;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void startGame() {
        init();
        doGame();
    }

    private void doGame() {
        printer.countOfLotto(money.getMoney() / CommonUnits.MONEY_UNIT);
        printer.allLotto(pocket.getLottos().stream().map(it -> new LottoNumberDTO(it.getNumbers()))
                .collect(Collectors.toList()));
        discriminator.setCorrectNumbers(getCorrectNumbers());
        discriminator.setBonus(getBonus());
        pocket.getLottos().stream().forEach(it -> discriminator.discriminate(it.getNumbers()));
        printer.statistic(discriminator.getStatistic());
        printer.profitRate(discriminator.getProfitRate(money.getMoney()));
    }

    private void init() {
        money = getPurchase();
        pocket = new Pocket(getLottos());
    }

    private Money getPurchase() {
        boolean flag = true;
        Money purchase;
        while (flag) {
            try {
                purchase = new Money(inputter.purchase());
                return purchase;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private List<Lotto> getLottos() {
        List<Lotto> lottos = new ArrayList<>();
        int count = money.getMoney() / CommonUnits.MONEY_UNIT;

        for (int i = 0 ; i < count ; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate().getLotto()));
        }

        return lottos;
    }

    private Lotto getCorrectNumbers() {
        boolean flag = true;
        Lotto lotto;
        while (flag) {
            try {
                lotto = new Lotto(inputter.lottoNumbers().getLotto());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private Bonus getBonus() {
        boolean flag = true;
        Bonus bonus;
        while (flag) {
            try {
                bonus = new Bonus(inputter.bonus());
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
