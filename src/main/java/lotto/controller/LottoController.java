package lotto.controller;

import java.util.List;
import lotto.model.Bank;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final Bank bank;
    private final InputView input;
    private final OutputView output;
    private LottoMachine lottoMachine;

    public LottoController() {
        bank = new Bank();
        input = new InputView();
        output = new OutputView();
    }

    public void start() {
        createLottoMachine();
        createUserNumbers();
    }

    private void createLottoMachine() {
        int money = input.inputMoney();
        lottoMachine = new LottoMachine(money);
        output.printLottoMessage(lottoMachine.getLottos());
    }

    private void createUserNumbers() {
        List<Integer> userNumbers = input.inputNumbers();
        int bonusNumber = input.inputBonus(userNumbers);
        makeResult(userNumbers, bonusNumber);
    }

    private void makeResult(List<Integer> userNumbers, int bonusNumber) {
        List<Lotto> lottos = lottoMachine.getLottos();
        List<Integer> ranks = bank.getRanks(lottos, userNumbers, bonusNumber);
        int profit = bank.getProfit(ranks);
        double profitRate = bank.getFormatProfitRate(lottos.size(), profit);
        output.printResult(ranks, profitRate);
    }
}
