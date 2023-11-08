package lotto.controller;

import static lotto.constants.Message.INPUT_BONUS_NUMBER;
import static lotto.constants.Message.INPUT_MONEY;
import static lotto.constants.Message.INPUT_WINNING_NUMBER;

import lotto.domain.LottoMachine;
import lotto.domain.Result;
import lotto.domain.WinningCondition;
import lotto.service.LottoService;
import lotto.view.ConsoleInputReader;
import lotto.view.OutputView;

public class LottoController {
    private ConsoleInputReader inputReader = new ConsoleInputReader();
    private OutputView outputView = new OutputView();
    private LottoMachine lottoMachine = new LottoMachine();
    private LottoService lottoService = new LottoService();

    public void run() {
        insertMoneyTo(lottoMachine);

        lottoMachine.generateLottos();
        outputView.printBoughtLottos(lottoMachine);

        WinningCondition winningCondition = generateWinningCondition();

        Result result = lottoService.calculateResult(lottoMachine, winningCondition);
        outputView.printLottoResult(result);
    }

    private WinningCondition generateWinningCondition() {
        WinningCondition winningCondition = new WinningCondition();
        try {
            inputWinningNumber(winningCondition);
            inputBonusNumber(winningCondition);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningCondition = generateWinningCondition();
        }
        return winningCondition;
    }

    private void inputBonusNumber(WinningCondition winningCondition) {
        String bonusNumber = inputReader.readInput(INPUT_BONUS_NUMBER);
        winningCondition.inputBonusNumbers(bonusNumber);
    }

    private void inputWinningNumber(WinningCondition winningCondition) {
        String winningNumber = inputReader.readInput(INPUT_WINNING_NUMBER);
        winningCondition.inputWinningNumbers(winningNumber);
    }

    private void insertMoneyTo(LottoMachine lottoMachine) {
        try {
            String inputMoney = inputReader.readInput(INPUT_MONEY);
            lottoMachine.insertMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            insertMoneyTo(lottoMachine);
        }
    }
}
