package lotto.controller;

import java.util.List;
import lotto.model.Bank;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoMachine lottoMachine;
    private Bank bank;
    private InputView input;
    private OutputView output;

    public LottoController(){
        bank = new Bank();
        input = new InputView();
        output = new OutputView();
    }

    public void start(){
        createLottoMachine();
        userOperation();
    }

    private void createLottoMachine(){
        int money = input.inputMoney();
        lottoMachine = new LottoMachine(money);
        output.printLottoMessage(lottoMachine.getLottos());
    }

    private void userOperation(){
        List<Integer> userNumbers = input.inputNumbers();
        int bonusNumber = input.inputBonus(userNumbers);
        makeResult(userNumbers, bonusNumber);
    }

    private void makeResult(List<Integer> userNumbers, int bonusNumber){
        List<Lotto> lottos = lottoMachine.getLottos();
        List<Integer> ranks = bank.getRanks(lottos, userNumbers, bonusNumber);
        int profit = bank.getProfit(ranks);
        double profitRate = bank.getFormatProfitRate(lottos.size(), profit);
        output.printResult(ranks, profitRate);
    }
}
