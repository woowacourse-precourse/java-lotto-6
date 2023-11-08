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
        // 구입 금액 입력
        insertMoneyTo(lottoMachine);

        // 로또 생성
        lottoMachine.generateLottos();
        outputView.printBoughtLottos(lottoMachine);

        // 정답 입력
        WinningCondition winningCondition = generateWinningCondition();

        // 결과 출력
        Result result = lottoService.calculateResult(lottoMachine, winningCondition);
        outputView.printLottoResult(result);
    }

    private WinningCondition generateWinningCondition() {
        WinningCondition winningCondition = new WinningCondition();
        try {
            String winningNumber = inputReader.readInput(INPUT_WINNING_NUMBER);
            winningCondition.inputWinningNumbers(winningNumber);

            String bonusNumber = inputReader.readInput(INPUT_BONUS_NUMBER);
            winningCondition.inputBonusNumbers(bonusNumber);
        } catch (RuntimeException e) {
            winningCondition = generateWinningCondition();
        }
        return winningCondition;
    }

    private void insertMoneyTo(LottoMachine lottoMachine) {
        try {
            String inputMoney = inputReader.readInput(INPUT_MONEY);
            lottoMachine.insertMoney(inputMoney);
        } catch (RuntimeException e) {
            insertMoneyTo(lottoMachine);
        }
    }
}
