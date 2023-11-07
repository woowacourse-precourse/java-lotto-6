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
        OutputView.writeBuyLottoPrice();
        String price = InputView.buyLottoPrice();

        int money = LottoValidator.divideMoney(price);
        int lottoTicketCount = LottoMachine.getLottoTicketNumber(money);

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
        OutputView.writeWinningNumber();
        String winningNumber = InputView.winningNumber();
        // todo 검증기 돌려야함
        List<Integer> winningNumbers = LottoTypeConverter.toList(winningNumber);
        winningLottoNumber = new WinningLottoNumber(winningNumbers);
    }

    public void setBonusNumber() {
        OutputView.writeBonusNumber();
        // todo 입력값 검증
        int bonusNumber = LottoValidator.checkBonusNumber(InputView.bonusNumber());
        winningLottoNumber.bonusNumber = bonusNumber;
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
