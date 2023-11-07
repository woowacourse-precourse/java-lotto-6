package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumberDTO;

public class GameController {
    private Pocket pocket;
    private Inputter inputter;
    private Printer printer;
    private Discriminator discriminator;
    private LottoNumberGenerator lottoNumberGenerator;
    private int money;

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
        printer.countOfLotto(money / CommonUnits.MONEY_UNIT);
        printer.allLotto(pocket.getLottos().stream().map(LottoNumberDTO::new)
                .collect(Collectors.toList()));
        discriminator.setCorrectNumbers(inputter.lottoNumbers().getLotto());
        discriminator.setBonus(inputter.bonus());
        pocket.getLottos().stream().forEach(it -> discriminator.discriminate(it));
        printer.statistic(discriminator.getStatistic());
        printer.profitRate(discriminator.getProfitRate(money));
    }

    private void init() {
        money = getPurchase();
        pocket = new Pocket(getLottos());
    }

    private int getPurchase() {
        boolean flag = true;
        int purchase = 0;
        while (flag) {
            try {
                purchase = inputter.purchase();
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchase;
    }

    private List<List<Integer>> getLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        int count = money / CommonUnits.MONEY_UNIT;

        for (int i = 0 ; i < count ; i++) {
            lottos.add(lottoNumberGenerator.generate().getLotto());
        }

        return lottos;
    }
}
