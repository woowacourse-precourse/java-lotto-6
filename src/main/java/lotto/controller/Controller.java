package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoProgram;
import lotto.dto.WinningStatisticsDto;
import lotto.view.InputVIew;
import lotto.view.OutputVIew;

public class Controller {
    private final LottoProgram lottoProgram;
    private final OutputVIew outputVIew;
    private final InputVIew inputVIew;

    public Controller() {
        lottoProgram = new LottoProgram();
        outputVIew = new OutputVIew();
        inputVIew = new InputVIew();
    }
    public void run() {
        //TODO: 전체 로직
        // - 1. 로또 구입 금액 입력 받기
        // - 2. 금액에 맞게 로또 출력하기
        // - 3. 당첨번호 입력받기
        // - 4. 보너스 번호 입력 받기
        // - 5. 수익 계산하기
        outputVIew.printForPurchaseAmount();
        int amount = inputVIew.promptLottoPurchaseAmount();
        List<Lotto> lottoListByPrice = lottoProgram.getLottoListByPrice(amount);
        outputVIew.printUserLottoList(lottoListByPrice);

        outputVIew.printWinningNumbersPrompt();
        List<Integer> winningNumbers = inputVIew.promptLottoWinningNumbers();
        outputVIew.printBonusNumberPrompt();
        int bonusNumber = inputVIew.promptLottoBonusNumber();
        WinningStatisticsDto winningNumber = lottoProgram.getWinningNumber(winningNumbers, bonusNumber);
        outputVIew.printWinningStatistics(winningNumber);
    }

}
