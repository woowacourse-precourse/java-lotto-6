package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<LottoTicket> purchaseLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / LottoTicket.PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(lottoMachine.generateTicket());
        }

        return tickets;
    }

    public LottoResult checkLottoTickets(List<LottoTicket> tickets, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for (LottoTicket ticket : tickets) {
            int matchCount = getMatchCount(ticket, winningLotto); // 티켓과 당첨 번호 확인 함수
            boolean matchBonus = checkBonusMatch(ticket, winningLotto); // 보너스 번호 확인 변수
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            lottoResult.addRank(rank);
        }

        return lottoResult;
    }

    private int getMatchCount(LottoTicket ticket, WinningLotto winningLotto) {
        List<Integer> ticketNumbers = ticket.getNumbers();
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

        return (int) ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

}
