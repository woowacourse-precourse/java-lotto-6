package lotto.controller;

import lotto.model.Lotto;
import lotto.model.ClientLottoData;
import lotto.model.WinningLottoNumber;
import lotto.util.LottoMachine;
import lotto.util.LottoTypeConverter;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    ClientLottoData clientLottoData;
    WinningLottoNumber winningLottoNumber;

    public void run() {
        startLotto();
        setClientLottoData();
        getClientLottoData();
        setWinningNumber();
        setBonusNumber();
        setMatchNumber();
        showWinningStatistic();
        getIncome();
    }

    public void startLotto() {
        OutputView.askBuyLottoPrice();
        String price = InputView.buyLottoPrice();

        int money = LottoValidator.divideMoney(price);
        int lottoTicketCount = LottoMachine.setLottoTicketNumber(money);

        clientLottoData = new ClientLottoData(money, lottoTicketCount);
    }

    public void setClientLottoData() {
        clientLottoData.lottos = LottoMachine.setLottoTicket(clientLottoData.lottoTicketCount);
    }

    public void getClientLottoData() {
        int numberLottoTicket = clientLottoData.lottoTicketCount;
        List<Lotto> lottos = clientLottoData.lottos;
        OutputView.boughtLottoNumber(numberLottoTicket, lottos);
    }

    public void setWinningNumber() {
        OutputView.askWriteWinningNumber();
        String winningNumber = InputView.winningNumber();
        // todo 검증기 돌려야함
        List<Integer> winningNumbers = LottoTypeConverter.toList(winningNumber);
        winningLottoNumber = new WinningLottoNumber(winningNumbers);
    }

    public void setBonusNumber() {
        OutputView.askWriteBonusNumber();
        // todo 입력값 검증
        winningLottoNumber.bonusNumber = LottoValidator.checkBonusNumber(InputView.bonusNumber());
    }

    public void setMatchNumber() {
        clientLottoData.matchLottoCalculate = LottoMachine.matchLottoCalculate(clientLottoData, winningLottoNumber);
    }

    public void showWinningStatistic() {
        OutputView.winningStatistics(clientLottoData.matchLottoCalculate);
    }
    public void getIncome() {
        double income = LottoMachine.setIncome(clientLottoData);
        OutputView.income(income);
    }
}
