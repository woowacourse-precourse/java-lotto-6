package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.BonusNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoTicketResult;
import lotto.lotto.ScratchedLottoTicket;
import lotto.lotto.WinningNumbers;

public class Calculator {
    private static final Integer FIVE_MATCH = 5;
    public Integer convertAmountToQuantity(Integer amount){
        return amount / MIN_VALUE.getAmount();
    }

    public ScratchedLottoTicket calculateWinner(WinningNumbers winningNumbers, BonusNumber bonusNumber, LottoTicket lottoTicket){
        List<Integer> findWinningNumbers = winningNumbers.winningNumbers();
        List<Integer> findLottoNumbers = lottoTicket.numbers();
        int winningPoint = (int)findLottoNumbers.stream().filter(findWinningNumbers::contains).count();
        boolean bonusStatus = findLottoNumbers.contains(bonusNumber.number()) && winningPoint == FIVE_MATCH;
        return new ScratchedLottoTicket(lottoTicket,winningPoint,bonusStatus);
    }

    public LottoTicketResult calculateResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, List<LottoTicket> lottoTickets){
        List<ScratchedLottoTicket> scratchedLottoTickets = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ScratchedLottoTicket scratchedLottoTicket = this.calculateWinner(winningNumbers, bonusNumber,lottoTicket);
            scratchedLottoTickets.add(scratchedLottoTicket);
        }
        return LottoTicketResult.createLottoResult(scratchedLottoTickets);
    }

}
