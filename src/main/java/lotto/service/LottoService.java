package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoResultRule;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.utils.RandomNumberGenerator;

public class LottoService {

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Ticket calculateTicketFromAmonut(final Amount amount) {
        return new Ticket(amount.divideByThousand());
    }

    public Lottos saveLottos(Ticket ticket) {
        List<Lotto> elements = Stream.generate(() -> new Lotto(randomNumberGenerator.generateUniqueSortedNumbers()))
                .limit(ticket.toValue())
                .toList();
        return new Lottos(elements);
    }

    public WinningStatistic compareLotto(final Lottos lottos, final WinningLotto winningLotto) {
        List<Integer> winningLottoNumbers = winningLotto.toLotto().getNumbers();
        Integer bonusNumber = winningLotto.toBonusNumber().toValue();
        EnumMap<LottoResultRule, Integer> enumMap = new EnumMap<>(LottoResultRule.class);

        for (Lotto lotto : lottos.toElements()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            long count = lottoNumbers.stream().filter(winningLottoNumbers::contains).distinct().count();
            if (count == 5 && lottoNumbers.contains(bonusNumber)) {
                incrementEnumMap(enumMap, LottoResultRule.matchCount(5, true));
            }
            incrementEnumMap(enumMap, LottoResultRule.matchCount(Integer.parseInt(String.valueOf(count)), false));
        }
        return new WinningStatistic(enumMap);
    }

    private void incrementEnumMap(EnumMap<LottoResultRule, Integer> enumMap, LottoResultRule key) {
        Integer value = enumMap.get(key);
        if (value == null) {
            value = 0;
        }
        value = value + 1;
        enumMap.put(key, value);
    }

    public String getPerformance(final WinningStatistic winningStatistic, final Amount amount) {
        Integer totalProfit = winningStatistic.getTotalProfit();
        Integer lottoAmount = amount.toValue();

        double dividedResult = (double) totalProfit / lottoAmount;
        double roundedResult = Math.round(dividedResult * 10000.0) / 10000.0 * 100.0;

        return Double.toString(roundedResult);
    }
}
