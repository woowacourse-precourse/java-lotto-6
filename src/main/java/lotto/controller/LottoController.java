package lotto.controller;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import lotto.mapper.LottoTicketsDtoMapper;
import lotto.dto.LottoTicketsDto;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.util.RandomLottoGenerator;
import lotto.view.Output;

public class LottoController {
    public void start() {
        Money money = InputController.getMoney();

        LottoTickets lottoTickets = getLottoTickets(money);
        LottoTicketsDto lottoTicketsDto = LottoTicketsDtoMapper.from(lottoTickets);
        Output.printLottoTickets(lottoTicketsDto);

        WinningLotto winningLotto = getWinningLotto();
        EnumMap<Rank, Integer> rank = getRank(winningLotto, lottoTickets);
        System.out.println(rank);
    }

    private LottoTickets getLottoTickets(Money money) {
        int ticket = money.getTicket();
        return LottoTickets.generateLottoTickets(new RandomLottoGenerator(), ticket);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = InputController.getWinningNumbers();
        BonusNumber bonusNumber = InputController.getBonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private EnumMap<Rank, Integer> getRank(WinningLotto winningLotto, LottoTickets lottoTickets) {
        EnumMap<Rank, Integer> rank = new EnumMap<>(Rank.class);
        EnumSet.allOf(Rank.class).forEach(grade -> rank.put(grade, 0));
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = winningLotto.calculateMatchCount(lottoTicket);
            Rank currentRank = Rank.findRankByMatchCount(matchCount, winningLotto.hasBonusNumber(lottoTicket));
            rank.put(currentRank, rank.get(currentRank) + 1);
        }
        return rank;
    }
}
