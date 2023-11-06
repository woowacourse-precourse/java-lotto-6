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
            List<Integer> LottoNumbers = lotto.getNumbers();
            Long count = LottoNumbers.stream().filter(winningLottoNumbers::contains).distinct().count();
            if (count == 5) {
                if (LottoNumbers.contains(bonusNumber)) {
                    enumMap.put(LottoResultRule.matchCount(Integer.parseInt(String.valueOf(count)), true), 1);
                }
                enumMap.put(LottoResultRule.matchCount(Integer.parseInt(String.valueOf(count)), false), 1);
            }
            enumMap.put(LottoResultRule.matchCount(Integer.parseInt(String.valueOf(count)), false), 1);
        }
        return new WinningStatistic(enumMap);
    }

}
