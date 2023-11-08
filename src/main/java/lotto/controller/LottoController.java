package lotto.controller;

import static lotto.constants.Message.INPUT_BONUS_NUMBER;
import static lotto.constants.Message.INPUT_MONEY;
import static lotto.constants.Message.INPUT_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Result;
import lotto.domain.WinningCondition;
import lotto.dto.LottoCompareResult;
import lotto.view.ConsoleInputReader;
import lotto.view.OutputView;

public class LottoController {
    private ConsoleInputReader inputReader = new ConsoleInputReader();
    private OutputView outputView = new OutputView();

    public void run() {
        LottoMachine lottoMachine = new LottoMachine();

        // 구입 금액 입력
        insertMoneyTo(lottoMachine);

        // 로또 생성
        lottoMachine.generateLottos();
        outputView.printGeneratedLottos(lottoMachine);

        // 정답 입력
        WinningCondition winningCondition = generateWinningCondition();

        // 결과 출력
        Result result = checkLottoResult(lottoMachine, winningCondition);
        outputView.printLottoResult(result);
    }

    private Result checkLottoResult(LottoMachine lottoMachine, WinningCondition winningCondition) {
        Result result = new Result();
        List<LottoCompareResult> lottoCompareResultList = new ArrayList<>();
        for (Lotto lotto : lottoMachine.getLottos()) {
            LottoCompareResult compareResult = winningCondition.compare(lotto);
            lottoCompareResultList.add(compareResult);
        }

        result.calculateTotalWinningMoney(lottoCompareResultList);
        result.calculateProfitRate(lottoMachine.getInputAmount());

        return result;
    }

    private WinningCondition generateWinningCondition() {
        WinningCondition winningCondition = new WinningCondition();
        try
        {
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
        String inputMoney = inputReader.readInput(INPUT_MONEY);
        lottoMachine.insertMoney(inputMoney);
    }
}
