package lotto.controller;

import static lotto.view.OutputLottoList.printLottoList;
import static lotto.view.OutputStatistics.printStatistics;
import static lotto.view.OutputTicketCountView.printCountOfLotto;

import java.util.List;
import lotto.Calculate;
import lotto.LottoList;
import lotto.ShowRanking;
import lotto.Ticket;
import lotto.WinNumber;
import lotto.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputNumberView;
import lotto.view.InputTicketView;

public class LottoController {

    public void run() {
        Ticket ticket = getLottoTicket();
        printCountOfLotto(ticket);

        LottoList lottoList = getLottoList(ticket);
        printLottoList(lottoList);

        WinNumber winNumber = getWinNumber();
        ShowRanking showRanking = new ShowRanking();
        calcLottoResult(showRanking, winNumber, lottoList);

        Calculate calculate = getCalculate(ticket, showRanking);
        printStatistics(showRanking, calculate);
    }

    private Ticket getLottoTicket() {
        InputTicketView inputTicketView = new InputTicketView();
        int money = inputTicketView.getMoney();
        return new Ticket(money);
    }

    private LottoList getLottoList(Ticket ticket) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new LottoList(lottoGenerator.generateLottoGroup(ticket.countTicket()));
    }

    private WinNumber getWinNumber() {
        InputNumberView inputNumberView = new InputNumberView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winNumbers = inputNumberView.getNumber();
        Integer bonusNumber = inputBonusNumberView.getBonusNumber();

        return new WinNumber(winNumbers, bonusNumber);
    }

    private void calcLottoResult(ShowRanking showRanking, WinNumber winNumber, LottoList lottoList) {
        showRanking.calcRankingResult(winNumber, lottoList);
    }

    private Calculate getCalculate(Ticket ticket, ShowRanking showRanking) {
        return new Calculate(ticket, showRanking);
    }
}
