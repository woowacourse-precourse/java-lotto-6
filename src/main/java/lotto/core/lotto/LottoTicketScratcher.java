package lotto.core.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.core.enums.AmountEnum;

public class LottoTicketScratcher {
    private static final Integer FIVE_MATCH = 5;
    public Integer convertAmountToQuantity(Integer amount){
        return amount / AmountEnum.MIN_VALUE.getAmount();
    }

    public ScratchedLottoTicket scratchTicket(WinningNumbers winningNumbers, BonusNumber bonusNumber, LottoTicket lottoTicket){
        List<Integer> findWinningNumbers = winningNumbers.getNumbers();
        List<Integer> findLottoNumbers = lottoTicket.getNumbers();
        int winningPoint = (int)findLottoNumbers.stream().filter(findWinningNumbers::contains).count();
        boolean bonusStatus = findLottoNumbers.contains(bonusNumber.number()) && winningPoint == FIVE_MATCH;
        return new ScratchedLottoTicket(lottoTicket,winningPoint,bonusStatus);
    }

    public ScratchedLottoTicketList scratchAllTickets(WinningNumbers winningNumbers, BonusNumber bonusNumber, List<LottoTicket> lottoTickets){
        List<ScratchedLottoTicket> scratchedLottoTickets = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ScratchedLottoTicket scratchedLottoTicket = this.scratchTicket(winningNumbers, bonusNumber,lottoTicket);
            scratchedLottoTickets.add(scratchedLottoTicket);
        }
        return ScratchedLottoTicketList.createLottoResult(scratchedLottoTickets);
    }

}
