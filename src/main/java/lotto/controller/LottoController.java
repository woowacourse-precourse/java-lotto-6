package lotto.controller;

import static lotto.constants.Message.INPUT_MONEY;

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
        WinningCondition winningCondition = new WinningCondition(inputReader);
        Result result = new Result();

        // 구입 금액 입력
        String inputMoney = inputReader.readInput(INPUT_MONEY);
        lottoMachine.insertMoney(inputMoney);
        outputView.printGeneratedLottos(lottoMachine);

        // 로또 생성
        lottoMachine.generateLottos();

        winningCondition.inputWinningNumbers();
        winningCondition.inputBonusNumbers();

        List<LottoCompareResult> compareResults = new ArrayList<>();
        for (Lotto lotto : lottoMachine.getLottos()) {
            LottoCompareResult compareResult = winningCondition.compare(lotto);
            compareResults.add(compareResult);
        }

        long totalProfit = result.getTotalWinningMoney(compareResults);

    }
}
