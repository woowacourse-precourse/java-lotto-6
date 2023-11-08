package lotto.controller;

import lotto.model.domain.Lotto;
import lotto.model.domain.ClientLottoData;
import lotto.model.domain.WinningLottoNumber;
import lotto.model.LottoMachine;
import lotto.util.LottoTypeConverter;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        ClientLottoData clientLottoData;
        WinningLottoNumber winningLottoNumber;
        clientLottoData = startLotto();
        setClientLottoData(clientLottoData);
        getClientLottoData(clientLottoData);

        winningLottoNumber = setWinningNumber();
        setBonusNumber(winningLottoNumber);
        setMatchNumber(clientLottoData, winningLottoNumber);
        showWinningStatistic(clientLottoData);
        getIncome(clientLottoData);
    }

    public ClientLottoData startLotto() {
        OutputView.askBuyLottoPrice();
        String price = InputView.buyLottoPrice();

        int money = 0;
        try {
            money = LottoValidator.divideMoney(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startLotto();
        }
        int lottoTicketCount = LottoMachine.setLottoTicketNumber(money);
        return new ClientLottoData(money, lottoTicketCount);
    }

    public void setClientLottoData(ClientLottoData clientLottoData) {
        // service의 역할
        clientLottoData.lottos = LottoMachine.setLottoTicket(clientLottoData.lottoTicketCount);
    }

    public void getClientLottoData(ClientLottoData clientLottoData) {
        int numberLottoTicket = clientLottoData.lottoTicketCount;
        List<Lotto> lottos = clientLottoData.lottos;
        OutputView.boughtLottoNumber(numberLottoTicket, lottos);
    }

    public WinningLottoNumber setWinningNumber() {
        OutputView.askWriteWinningNumber();
        String winningNumber = InputView.winningNumber();
        // todo 검증기 돌려야함
        List<Integer> winningNumbers = LottoTypeConverter.toList(winningNumber);
        return new WinningLottoNumber(winningNumbers);
    }

    public void setBonusNumber(WinningLottoNumber winningLottoNumber) {
        OutputView.askWriteBonusNumber();
        // todo 입력값 검증
        winningLottoNumber.bonusNumber = LottoValidator.checkBonusNumber(InputView.bonusNumber());
    }

    public void setMatchNumber(ClientLottoData clientLottoData, WinningLottoNumber winningLottoNumber) {
        clientLottoData.matchLottoCalculate = LottoMachine.matchLottoCalculate(clientLottoData, winningLottoNumber);
    }

    public void showWinningStatistic(ClientLottoData clientLottoData) {
        OutputView.winningStatistics(clientLottoData.matchLottoCalculate);
    }

    public void getIncome(ClientLottoData clientLottoData) {
        double income = LottoMachine.setIncome(clientLottoData);
        OutputView.income(income);
    }
}
