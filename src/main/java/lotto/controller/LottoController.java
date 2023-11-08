package lotto.controller;

import lotto.model.domain.ClientLottoData;
import lotto.model.domain.RankTable;
import lotto.model.domain.WinningLottoNumber;
import lotto.model.LottoMachine;
import lotto.util.LottoTypeConverter;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private static LottoController lottoController = new LottoController();

    private LottoController() {
    }

    public static LottoController getLottoController() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void run() {
        ClientLottoData clientLottoData = new ClientLottoData();
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber();
        startLotto(clientLottoData);
        clientLottoData.setLottoTicket(clientLottoData.getLottoTicketCount());
        getClientLottoData(clientLottoData);
        setWinningNumber(winningLottoNumber);
        setBonusNumber(winningLottoNumber);
        setMatchNumber(clientLottoData, winningLottoNumber);
        showWinningStatistic(clientLottoData);
        getIncome(clientLottoData);
    }

    public void startLotto(ClientLottoData clientLottoData) {
        OutputView.askBuyLottoPrice();
        String price = InputView.buyLottoPrice();
        try {
            int money = LottoValidator.divideMoney(price);
            clientLottoData.setPrice(money);
            clientLottoData.setLottoTicketNumber(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startLotto(clientLottoData);
        }
    }

    public void getClientLottoData(ClientLottoData clientLottoData) {
        int numberLottoTicket = clientLottoData.getLottoTicketCount();
        OutputView.boughtLottoNumber(numberLottoTicket, clientLottoData.getLottos());
    }

    public void setWinningNumber(WinningLottoNumber winningLottoNumber) {
        OutputView.askWriteWinningNumber();
        String[] rawNumbers = LottoTypeConverter.toArray(InputView.winningNumber());
        try {
            LottoValidator.checkWinningNumber(rawNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningNumber(winningLottoNumber);
        }
        List<Integer> winningNumbers = LottoTypeConverter.toList(rawNumbers);
        winningLottoNumber.setWinningNumberWithBonusNumber(winningNumbers);
    }

    public void setBonusNumber(WinningLottoNumber winningLottoNumber) {
        OutputView.askWriteBonusNumber();
        try {
            int bonusNumber = LottoValidator.checkBonusNumber(InputView.bonusNumber(),
                    winningLottoNumber.getWinningNumberWithBonusNumber());
            winningLottoNumber.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber(winningLottoNumber);
        }
    }

    public void setMatchNumber(ClientLottoData clientLottoData, WinningLottoNumber winningLottoNumber) {
        List<RankTable> rankTables = LottoMachine.matchLottoCalculate(clientLottoData, winningLottoNumber);
        clientLottoData.setMatchLottoCalculate(rankTables);
    }

    public void showWinningStatistic(ClientLottoData clientLottoData) {
        OutputView.winningStatistics(clientLottoData.getMatchLottoCalculate());
    }

    public void getIncome(ClientLottoData clientLottoData) {
        String income = LottoTypeConverter.percent(clientLottoData.setIncome());
        OutputView.income(income);
    }
}
