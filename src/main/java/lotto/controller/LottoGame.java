package lotto.controller;

import lotto.config.WinningPrize;
import lotto.domain.*;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int END_OF_REPEAT = 0;

    private BuyingPrice buyingPrice;
    private final List<Lotto> lottos = new ArrayList<>();
    private final WinningNumber winning = new WinningNumber();
    private final LottoResult result = new LottoResult();

    public void run() {
        inputBuyingPrice();
        createLotto();
        inputWinningNumber();
        inputBonusNumber();
        printResult();
    }

    private void inputBuyingPrice() {
        try {
            int price = Parser.parseIntOrThrow(InputView.inputBuyingPrice());
            buyingPrice = new BuyingPrice(price);
            OutputView.newLine();
            OutputView.printBuyingCount(buyingPrice.getTryCount());
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error);
            inputBuyingPrice();
        }
    }

    private void createLotto() {
        int tryCount = buyingPrice.getTryCount();
        while (tryCount-- > END_OF_REPEAT) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
            OutputView.printEachLotto(numbers);
        }
        OutputView.newLine();
    }

    private void inputWinningNumber() {
        try {
            List<Integer> numbers = Parser.parseIntListOrThrow(InputView.inputWinningNumber());
            winning.setNumbers(new Lotto(numbers));
            OutputView.newLine();
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error);
            inputWinningNumber();
        }
    }

    private void inputBonusNumber() {
        try {
            int bonus = Parser.parseIntOrThrow(InputView.inputBonusNumber());
            winning.setBonus(bonus);
            OutputView.newLine();
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error);
            inputBonusNumber();
        }
    }

    private void makeResult() {
        for (Lotto lotto : lottos) {
            WinningPrize prize = winning.compareWithLotto(lotto);
            result.apply(prize);
        }
    }

    private void printResult() {
        makeResult();
        OutputView.printResultTitle();
        for (WinningPrize prize : WinningPrize.values()) {
            OutputView.printEachResult(prize, result.getEachResult(prize));
        }
        OutputView.printProfitResult(result.getFinalProfit());
    }
}
