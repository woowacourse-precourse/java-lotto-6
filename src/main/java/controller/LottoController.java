package controller;

import model.*;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LottoService service;

    public void start() {
        Amount amount = inputAmount();

        AllLotto allLotto = printAllLotto(amount);

        Lotto lotto = inputWinningNumbers();

        WinningLotto winningLotto = inputBonus(lotto);

        printResult(allLotto, winningLotto, amount);
    }

    private Amount inputAmount() {
        try {
            String money = inputView.inputMoney();
            return new Amount(money); //error return
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputAmount();
        }
    }

    private AllLotto printAllLotto(Amount amount) {
        try {
            outputView.printLottoCount(amount.getCount());
            AllLotto allLotto = new AllLotto(amount.getCount());
            for (int i = 0; i < amount.getCount(); i++) {
                outputView.printLottos(allLotto.getLotto(i));
            }
            return allLotto;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return printAllLotto(amount);
        }
    }

    private Lotto inputWinningNumbers() {
        try {
            return new Lotto(inputView.inputWinning());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
    }

    private WinningLotto inputBonus(Lotto lotto) {
        try {
            String bonus = inputView.inputBonus();
            return new WinningLotto(lotto, bonus); //보너스 번호 error
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonus(lotto);
        }
    }

    private void printResult(AllLotto allLotto, WinningLotto winLotto, Amount amount) {
        service = new LottoService(allLotto, winLotto.getWinningLotto().getNumbers(), winLotto.getBonus());
        ResultLottos resultLottos = service.createResults();
        outputView.printResult(resultLottos);
        outputView.printReturnRate(service.calculateReturnRate(resultLottos, amount.getAmount()));
    }
}
