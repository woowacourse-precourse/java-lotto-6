package lotto.controller;

import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.PrizeCalculator;
import lotto.service.RandomLottoGenerator;
import lotto.service.ReturnRateCalculator;
import lotto.utils.PrizeCalculatorBuilder;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Game {

    private int purchaseAmount;
    private Lottos purchaseLottos;
    private Lotto prizeLotto;
    private int bonusNumber;
    private List<Entry<Integer, Boolean>> result;

    public void start() {
        init();
        progress();
        finish();
    }

    private void init() {
        purchaseAmount = ConsoleInput.inputAmount();
        ConsoleOutput.printPurchaseAmount(purchaseAmount);
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(purchaseAmount);
        purchaseLottos = randomLottoGenerator.generate();
        ConsoleOutput.printAllRandomsLottos(purchaseLottos);
        prizeLotto = ConsoleInput.inputPrizeNumbers();
        bonusNumber = ConsoleInput.inputBonusNumber(prizeLotto);
    }

    private void progress() {
        PrizeCalculator prizeCalculator = new PrizeCalculatorBuilder().lottos(purchaseLottos)
                .prizeLotto(prizeLotto)
                .bonusNumber(bonusNumber)
                .build();
        result = prizeCalculator.caculatePrize();
    }

    private void finish() {
        ReturnRateCalculator returnRateCalculator = new ReturnRateCalculator(result, purchaseAmount);
        double returnRate = returnRateCalculator.calculateReturnRate();
        ConsoleOutput.printPrizeStatistics(result);
        ConsoleOutput.printReturnRate(returnRate);
    }
}
