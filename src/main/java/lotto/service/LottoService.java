package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constant.LottoConstant;
import lotto.constant.LottoResultRule;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.utils.RandomNumberGenerator;

public class LottoService {

    private final RandomNumberGenerator randomNumberGenerator;

    public LottoService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Ticket calculateTicketFromAmonut(final PurchaseAmount purchaseAmount) {
        return new Ticket(purchaseAmount.getDivideByThousand());
    }

    public Lottos saveLottos(final Ticket ticket) {
        List<Lotto> elements = Stream.generate(() -> new Lotto(randomNumberGenerator.generateUniqueNumbers()))
                .limit(ticket.toValue())
                .toList();
        return new Lottos(elements);
    }

    public WinningStatistic compareLotto(final Lottos lottos, final WinningLotto winningLotto) {
        final List<Integer> winningLottoNumbers = winningLotto.toLotto().getNumbers();
        final Integer bonusNumber = winningLotto.toBonusNumber().toValue();
        final Map<LottoResultRule, Integer> enumMap = new EnumMap<>(LottoResultRule.class);

        for (Lotto lotto : lottos.toElements()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            long count = lottoNumbers.stream().filter(winningLottoNumbers::contains).distinct().count();
            if (count == LottoConstant.BONUS_NUMBER_CHECK && lottoNumbers.contains(bonusNumber)) {
                incrementEnumMap(enumMap, LottoResultRule.matchCount(LottoConstant.BONUS_NUMBER_CHECK, true));
            }
            if (count == LottoConstant.BONUS_NUMBER_CHECK && !lottoNumbers.contains(bonusNumber)) {
                incrementEnumMap(enumMap, LottoResultRule.matchCount(LottoConstant.BONUS_NUMBER_CHECK, false));

            }
            if (count != LottoConstant.BONUS_NUMBER_CHECK) {
                incrementEnumMap(enumMap, LottoResultRule.matchCount(Integer.parseInt(String.valueOf(count)), false));
            }
        }
        return new WinningStatistic(enumMap);
    }

    private void incrementEnumMap(final Map<LottoResultRule, Integer> enumMap, final LottoResultRule key) {
        Integer value = enumMap.get(key);
        if (value == null) {
            value = LottoConstant.ZERO;
        }
        value = value + LottoConstant.ONE;
        enumMap.put(key, value);
    }

    public String getPerformance(final WinningStatistic winningStatistic, final PurchaseAmount purchaseAmount) {
        final Integer totalProfit = winningStatistic.getTotalPrize();
        final Integer lottoAmount = purchaseAmount.toValue();
        double totalRate = (totalProfit.doubleValue() / lottoAmount) * LottoConstant.ONE_HUNDRED;
        Double roundedResult = Math.round(totalRate * LottoConstant.ONE_HUNDRED) / LottoConstant.ONE_HUNDRED;
        return roundedResult.toString();
    }
}
