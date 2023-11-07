package lotto.controller;

import static lotto.util.RetryUtil.read;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoCollectionGenerator;
import lotto.domain.LottoCount;
import lotto.domain.BonusNumber;
import lotto.domain.MatchingCase;
import lotto.domain.NumberGenerator;
import lotto.domain.Profit;
import lotto.domain.Purchase;
import lotto.dto.WinningNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberGenerator numberGenerator;

    public LottoController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Purchase purchase = read(this::readPurchase);
        LottoCount lottoCount = createLottoCount(purchase);
        OutputView.printLottoCount(lottoCount.getCount());

        LottoCollection lottoCollection = createLottoCollection(lottoCount);
        OutputView.printLottoCollection(lottoCollection.getLottoCollection());

        List<MatchingCase> matchingResult = calculateMatchingResult(lottoCollection);
        Profit profit = calculateProfit(matchingResult, purchase);

        displayResults(matchingResult, profit);
    }

    private Purchase readPurchase() {
        int rawPurchase = read(InputView::inputPurchase);
        return Purchase.from(rawPurchase);
    }

    private LottoCount createLottoCount(Purchase purchase) {
        return LottoCount.from(purchase.getPurchase());
    }

    private LottoCollection createLottoCollection(LottoCount lottoCount) {
        LottoCollectionGenerator lottoCollectionGenerator = new LottoCollectionGenerator(lottoCount.getCount(),
                numberGenerator);
        return LottoCollection.from(lottoCollectionGenerator.generate());
    }

    private List<MatchingCase> calculateMatchingResult(LottoCollection lottoCollection) {
        MatchingCase.NEW_GAME.initMatchingCase();
        Lotto winningLotto = readWinningLotto();
        BonusNumber bonusNumber = readBonusNumber(winningLotto);
        lottoCollection.applyResults(winningLotto, bonusNumber.getNumber());
        return MatchingCase.NEW_GAME.getResult();
    }

    private Lotto readWinningLotto() {
        return read(this::getWinningLottoFromInput);
    }

    private Lotto getWinningLottoFromInput() {
        WinningNumbersDto winningNumbersDto = read(InputView::inputWinningNumbers);
        return new Lotto(winningNumbersDto.winningNumbers());
    }

    private BonusNumber readBonusNumber(Lotto winningLotto) {
        return read(this::getBonusNumberFromInput, winningLotto);
    }

    private BonusNumber getBonusNumberFromInput(Lotto winningLotto) {
        int rawBonusNumber = read(InputView::inputBonusNumber);
        return BonusNumber.from(rawBonusNumber, winningLotto.getNumbers());
    }

    private Profit calculateProfit(List<MatchingCase> matchingResult, Purchase purchase) {
        return Profit.from(matchingResult, purchase.getPurchase());
    }

    private void displayResults(List<MatchingCase> matchingResult, Profit profit) {
        OutputView.printResult(matchingResult);
        OutputView.printProfit(profit.getProfit());
    }
}
