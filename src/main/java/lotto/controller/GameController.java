package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import net.bytebuddy.dynamic.scaffold.inline.DecoratingDynamicTypeBuilder;

import java.util.List;
import java.util.Map;

public class GameController {
    private final InputView input;
    private final OutputView output;
    private Customer customer;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        try {
            String money = input.inputMoney().trim();
            customer = new Customer(money);
            resultBuyLotto();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            start();
        }
    }

    private void resultBuyLotto() {
        customer.buyNewLotto();
        int num = customer.calculateLottoNum();
        List<String> texts = customer.getLottoTexts();

        output.printLottoNumAndNumbers(num, texts);
        createWinningLotto();
    }

    private void createWinningLotto() {
        try {
            String result = input.inputWinningLotto().trim();
            WinningLotto lotto = new WinningLotto(List.of(result.split(",")));
            plusBonusNumber(lotto);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            createWinningLotto();
        }
    }

    private void plusBonusNumber(WinningLotto lotto) {
        try {
            String number = input.inputBonusNumber().trim();
            lotto.plusBonusNumber(List.of(number));
            processLottoGame(lotto);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            plusBonusNumber(lotto);
        }
    }

    private void processLottoGame(WinningLotto winningLotto) {
        List<Lotto> buyLotto = customer.getAllLotto();
        List<Rank> gameResult = winningLotto.judgeLottoGame(buyLotto);
        Ranks ranks = new Ranks(gameResult);
        resultLottoGame(ranks);
    }

    private void resultLottoGame(Ranks ranks) {
        Map<Integer, Integer> countResult = ranks.countRankNum();
        Double winningSum = ranks.calculateWinningSum();

        output.printLottoResult(countResult);
        resultRevenueRatio(winningSum);
    }

    private void resultRevenueRatio(Double sum) {
        Double result = customer.calculateRevenueRatio(sum);
        output.printRevenueRatio(result);
    }
}
