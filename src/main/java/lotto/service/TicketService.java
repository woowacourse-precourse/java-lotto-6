package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Ticket;

public class TicketService {
    public static Ticket createTicket(final int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoService.createLotto())
                .collect(Collectors.toList());
        return new Ticket(lottos);
    }

    public static double getWinningRate(
            Ticket ticket,
            List<Integer> winningNumbers,
            int bonusNumber)
    {
        double winningAmount = getWinningAmount(ticket, winningNumbers, bonusNumber);
        return Math.round(winningAmount / ticket.getPurchaseAmount() * 100 * 10) / 10.0;
    }

    private static double getWinningAmount(
            final Ticket ticket,
            final List<Integer> winningNumbers,
            final int bonusNumber)
    {
        return ticket.getLottos()
                .stream()
                .map(lotto -> LottoService.getResult(lotto, winningNumbers, bonusNumber))
                .mapToDouble(Prize::getPrizeMoney).sum();
    }
}
