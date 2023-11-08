package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.LottoTicket;

public class LottoTicketService {
    public static LottoTicket createTicket(final int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoService.createLotto())
                .collect(Collectors.toList());
        return new LottoTicket(lottos);
    }

    public static double getProfitRate(
            LottoTicket lottoTicket,
            List<Integer> winningNumbers,
            int bonusNumber)
    {
        double winningAmount = getWinningAmount(lottoTicket, winningNumbers, bonusNumber);
        return Math.round(winningAmount / lottoTicket.getPurchaseAmount() * 100 * 10) / 10.0;
    }

    public static EnumMap<Prize, Integer> getStatistics(
            LottoTicket lottoTicket,
            List<Integer> winningNumbers,
            int bonusNumber)
    {
        EnumMap<Prize, Integer> statistics = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            statistics.put(prize, 0);
        }
        lottoTicket.getLottos()
                .forEach(lotto -> {
                    Prize prize = LottoService.getResult(lotto, winningNumbers, bonusNumber);
                    statistics.put(prize, statistics.get(prize) + 1);
                });
        return statistics;
    }

    private static double getWinningAmount(
            final LottoTicket lottoTicket,
            final List<Integer> winningNumbers,
            final int bonusNumber)
    {
        return lottoTicket.getLottos()
                .stream()
                .map(lotto -> LottoService.getResult(lotto, winningNumbers, bonusNumber))
                .mapToDouble(Prize::getPrizeMoney).sum();
    }
}
