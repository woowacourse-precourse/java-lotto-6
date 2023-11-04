package controller;

import domain.BonusNumber;
import domain.LottoMachine;
import domain.LottoTicket;
import domain.WinningNumbers;

import java.util.List;

public class LottoController {
    public int start(String inputValue) {
        LottoTicket lottoTicket = new LottoTicket();

        return lottoTicket.lottoTicketService(inputValue);


    }
    public List<List<Integer>> lottoTicketCount(int lottoTicketCount){
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.lottoMachineService(lottoTicketCount);
    }
    public List<Integer> winningNumber(List<List<Integer>> totalLottoTickets){
        WinningNumbers winningNumbers = new WinningNumbers();
        return winningNumbers.winningNumbersService(totalLottoTickets);
    }

    public List<Integer> bonusNumber(List<Integer> winningNumber) {
        return BonusNumber.bonusNumberService(winningNumber);
    }
}
