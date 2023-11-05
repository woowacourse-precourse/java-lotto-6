package lotto.controller;

import java.util.List;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.WinningList;
import lotto.model.WinningNumber;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Amount amount = inputAmount();
        List<Lotto> lottos = buyLotto(amount);
        printLotto(lottos);
        WinningList winningList = calculateWinning(lottos);
        printWinningList(winningList);
        calculateAndPrintProfitRate(winningList, amount);
    }

    private Amount inputAmount() {
        System.out.println();
        return new Amount(inputView.inputAmount());
    }

    private List<Lotto> buyLotto(Amount amount) {
        return amount.buyLotto();
    }

    private void printLotto(List<Lotto> lottos) {
        List<String> lottoList = lottos.stream()
                .map(Lotto::makeLottoNumberString)
                .toList();
        outputView.printLottoList(lottos.size(), lottoList);
    }

    private WinningList calculateWinning(List<Lotto> lottos) {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());
        List<LottoNumberRecord> numberRecordList = lottos.stream().map(Lotto::toRecord).toList();
        return new WinningList(numberRecordList, winningNumber);
    }

    private void printWinningList(WinningList winningList) {
        outputView.printWinningList(winningList.printWinningListString());
    }

    private void calculateAndPrintProfitRate(WinningList winningList, Amount amount) {
        AmountRecord amountRecord = amount.toRecord();
        ProfitRate profitRate = winningList.calculateProfitRate(amountRecord);
        String printProfitRate = profitRate.printProfitRate();
        outputView.printProfitRate(printProfitRate);
    }
}
