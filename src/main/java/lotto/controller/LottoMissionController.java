package lotto.controller;

import lotto.common.MultiplePureNumbers;
import lotto.common.PureNumber;
import lotto.service.LottoService;
import lotto.view.ConsoleView;

public class LottoMissionController {

    private LottoService service;

    public LottoMissionController() {
        service = new LottoService();
    }

    public ConsoleView purchaseRequiredAmount(PureNumber number) throws IllegalArgumentException {
        return ConsoleView.holdingsView(service.issueRequiredAmountOfLotteryTickets(number));
    }

    public void setWinningNumbers(MultiplePureNumbers numbers) throws IllegalArgumentException {
        service.setWinningNumbers(numbers);
    }

    public void setBonusNumber(PureNumber number) throws IllegalArgumentException {
        service.setBonusNumber(number);
    }

    public ConsoleView draw() {
        return ConsoleView.reportView(service.analyzePortfolio());
    }
}
