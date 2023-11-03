package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.Result;
import lotto.service.Calculator;
import lotto.service.LottoGenerator;
import lotto.service.LottoIssuer;
import lotto.service.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
        NumberGenerator<List<Integer>> generator = new LottoGenerator();
        Integer lottoTicket = buyLottoTicket(Integer.parseInt(purchaseAmount));
        LottoIssuer lottoIssuer = new LottoIssuer(lottoTicket, generator);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        Lotto winningNumbers = readWinningNumbers();
        Bonus bonusNumber = readBonusNumber();
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto lotto : boughtLotto) {
            lottoPrizes.add(LottoPrize.from(winningNumbers.count(lotto), bonusNumber.hasBonusNumber(lotto)));
        }
        Result result = Result.from(lottoPrizes);
        outputView.printWinningStatistics(result);
        Calculator calculator = new Calculator();
        Double totalReturn = calculator.calculatePrize(lottoPrizes);
        outputView.printTotalReturn(totalReturn);
    }

    private Lotto readWinningNumbers() {
        return new Lotto(Arrays.stream(inputView.readWinningNumbers().split(","))
                .map(Integer::parseInt)
                .toList());
    }

    private Bonus readBonusNumber() {
        Integer number = Integer.parseInt(inputView.readBonusNumber());
        return new Bonus(number);
    }

    private Integer buyLottoTicket(Integer amount) {
        return amount / 1000;
    }
}
