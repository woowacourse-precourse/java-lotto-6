package lotto.controller;

import lotto.converter.Converter;
import lotto.converter.StringToInteger;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
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
    private final Converter<String, Integer> integerConverter = new StringToInteger(); //TODO: 이게 최선인가


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount amount = readPurchaseAmount();
        Integer lottoTicket = exchangeLottoTicket(amount);
        NumberGenerator<List<Integer>> generator = new LottoGenerator();
        LottoIssuer lottoIssuer = new LottoIssuer(lottoTicket, generator); //TODO: 아예 issuer에 purchaseAmount 넘겨줘보기
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        Lotto lotto = readWinningNumbers();
        WinningLotto winningLotto = getWinningLotto(lotto);
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto bought : boughtLotto) {
            lottoPrizes.add(winningLotto.from(bought));
        }
        Result result = Result.from(lottoPrizes);
        outputView.printWinningStatistics(result);
        Calculator calculator = new Calculator();
        Double totalReturn = calculator.calculatePrize(lottoPrizes);
        outputView.printTotalReturn(totalReturn);
    }

    private WinningLotto getWinningLotto(Lotto lotto) {
        Bonus bonusNumber = readBonusNumber();
        try {
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private Lotto readWinningNumbers() {
        try {
            List<Integer> numbers = Arrays.stream(inputView.readWinningNumbers().split(","))
                    .map(integerConverter::convert)
                    .toList();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private Bonus readBonusNumber() {
        try {
            Integer number = integerConverter.convert(inputView.readBonusNumber());
            return new Bonus(number);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private PurchaseAmount readPurchaseAmount() {
        try {
            Integer number = integerConverter.convert(inputView.readPurchaseAmount());
            return PurchaseAmount.of(number);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private Integer exchangeLottoTicket(PurchaseAmount purchaseAmount) {
        return purchaseAmount.exchangeLottoTicket();
    }
}
