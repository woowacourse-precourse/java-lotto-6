package lotto.view;

import lotto.dto.LottoStatisticsResult;
import lotto.dto.LottoTickets;
import java.util.List;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int requirePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.enterPurchaseAmount();
    }

    public void showLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTickets(lottoTickets);
    }

    public List<Integer> requireLottoWinningNumbers() {
        outputView.requestLottoWinningNumbers();
        return inputView.enterWinningLottoNumbers();
    }

    public int requireBonusLottoNumber() {
        outputView.requestBonusLottoNumber();
        return inputView.enterBonusLottoNumber();
    }

    public void showLottoStatisticsResult(LottoStatisticsResult lottoStatisticsResult) {
        outputView.printLottoStatisticsResult(lottoStatisticsResult);
    }

    public void showExceptionMessage(String exceptionMessage) {
        outputView.printExceptionMessage(exceptionMessage);
    }
}
