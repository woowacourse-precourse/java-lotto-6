package controller;

import domain.*;

import java.util.List;
import java.util.Map;

public class LottoController {
    public int start() {
        LottoTicket lottoTicket = new LottoTicket();

        return lottoTicket.lottoTicketService();


    }
    public List<List<Integer>> lottoTicketCount(int lottoTicketCount){
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.lottoMachineService(lottoTicketCount);
    }
    public List<Integer> winningNumber(){
        WinningNumbers winningNumbers = new WinningNumbers();
        return winningNumbers.winningNumbersService();
    }

    public int bonusNumber(List<Integer> winningNumber) {
        BonusNumber bonusNumber = new BonusNumber();
        return bonusNumber.bonusNumberService(winningNumber);
    }

    public Map<String, Integer> checkWinners(List<List<Integer>> totalLottoTickets, List<Integer> winningNumber, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        return lottoResult.checkWinnersCountService(totalLottoTickets, winningNumber,bonusNumber);
    }

    public float totalPrizeMoney(Map<String, Integer> resultsCount, int inputMoney) {
        TotalPrizeMoney totalPrizeMoney = new TotalPrizeMoney();
        return totalPrizeMoney.totalPrizeMoneyService(resultsCount,inputMoney);
    }
}
