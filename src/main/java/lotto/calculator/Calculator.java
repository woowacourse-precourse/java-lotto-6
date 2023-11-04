package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.lotto.BonusNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.WinnerLottoTicket;
import lotto.lotto.WinningNumbers;

public class Calculator {

    public Integer convertAmountToQuantity(Integer amount){
        return amount / MIN_VALUE.getAmount();
    }

    public WinnerLottoTicket calculateWinner(WinningNumbers winningNumbers, BonusNumber bonusNumber, LottoTicket lottoTicket){
        List<Integer> totalWinningNumbers = new ArrayList<>(winningNumbers.winningNumbers());
        totalWinningNumbers.add(bonusNumber.number());
        List<Integer> findLottoNumbers = lottoTicket.numbers();
        Integer winningPoint = findLottoNumbers.stream().filter(totalWinningNumbers::contains).toList().size();
        return new WinnerLottoTicket(lottoTicket,winningPoint);
    }

    public  List<WinnerLottoTicket> sortWinner(WinningNumbers winningNumbers, BonusNumber bonusNumber, List<LottoTicket> lottoTickets){
        List<WinnerLottoTicket> winnerLottoTickets = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            WinnerLottoTicket winnerLottoTicket = this.calculateWinner(winningNumbers, bonusNumber,lottoTicket);
            winnerLottoTickets.add(winnerLottoTicket);
        }
        return winnerLottoTickets;
    }

}
