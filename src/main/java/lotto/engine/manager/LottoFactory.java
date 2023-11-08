package lotto.engine.manager;

import static lotto.engine.LottoSystemConstant.LOTTO_MAXIMUM_NUMBER_OF_WINNINGS;
import static lotto.engine.LottoSystemConstant.LOTTO_MINIMUM_NUMBER_OF_WINNINGS;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_MINIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.LOTTO_PRICE;
import static lotto.engine.LottoSystemConstant.LOTTO_SPECIAL_MATCH_CONDITION_NUMBER;
import static lotto.engine.LottoSystemConstant.WINNING_PRIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.engine.domain.Customer;
import lotto.engine.domain.Lotto;
import lotto.engine.dto.WinningResult;

public class LottoFactory {

    public LottoFactory() {
    }

    public List<Lotto> issueLotto(int quantity) {
        return Stream.generate(() -> Randoms.pickUniqueNumbersInRange(
                        LOTTO_NUMBER_MINIMUM_VALUE.value(),
                        LOTTO_NUMBER_MAXIMUM_VALUE.value(),
                        LOTTO_NUMBER_LENGTH.value())
                )
                .limit(quantity)
                .map(ArrayList::new)
                .peek(Collections::sort)
                .map(Lotto::new)
                .toList();
    }

    public String showTotalLotto(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::showNumbers)
                .collect(Collectors.joining("\n"));
    }

    public WinningResult aggregate(Customer customer, List<Lotto> lottos) {
        Map<Integer, Integer> winningResult = createWinningResult();
        AtomicInteger specialMatchCount = new AtomicInteger();
        lottos.stream()
                .filter(lotto -> lotto.matchCount(customer) >= LOTTO_MINIMUM_NUMBER_OF_WINNINGS.value())
                .forEach(lotto -> {
                    int count = lotto.matchCount(customer);
                    winningResult.put(count, winningResult.get(count) + 1);

                    boolean isSatisfy = lotto.isMatchSpecialCondition(customer,
                            LOTTO_SPECIAL_MATCH_CONDITION_NUMBER.value());
                    if (isSatisfy) {
                        specialMatchCount.getAndIncrement();
                    }
                });

        double profit = calculateProfit(lottos, winningResult, specialMatchCount.get());

        return new WinningResult(profit, winningResult, specialMatchCount.get());
    }

    private double calculateProfit(List<Lotto> lottos,
                                   Map<Integer, Integer> winningResult,
                                   int specialMatchCount
    ) {
        Integer winningPrize = getWinningPrize(winningResult, specialMatchCount);
        int cost = lottos.size() * LOTTO_PRICE.value();

        return (winningPrize.doubleValue() / cost) * 100;
    }

    private Integer getWinningPrize(Map<Integer, Integer> winningResult, int specialMatchCount) {
        Integer winningPrize = IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER_OF_WINNINGS.value(),
                        LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value())
                .boxed()
                .map(correctNumber -> WINNING_PRIZE.value().get(correctNumber) * winningResult.get(correctNumber))
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
        winningPrize += LOTTO_SPECIAL_MATCH_CONDITION_NUMBER.value() * specialMatchCount;

        return winningPrize;
    }

    private Map<Integer, Integer> createWinningResult() {
        return IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER_OF_WINNINGS.value(),
                        LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value())
                .boxed()
                .collect(Collectors.toMap((key) -> key, (value) -> 0));
    }
}
