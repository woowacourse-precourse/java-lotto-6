package lotto.domain;

import lotto.common.LottoCommonString;
import lotto.common.LottoWinnerTable;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class LottoWinnerCounter {
    private EnumMap<LottoWinnerTable, Integer> winnerCounter;

    public static LottoWinnerCounter generateLottoWinnerCounter() {
        return new LottoWinnerCounter();
    }

    public void calculateLottoResult(Lottos lottos, Lotto winningNumber, BonusNumber bonusNumber) {
        lottos.getLottos().stream()
                .map(lotto -> lotto.compareWinningNumber(winningNumber, bonusNumber))
                .forEach(this::addCount);
    }

    public List<String> getWinnerInformation() {
        return this.winnerCounter.entrySet().stream()
                .filter(winner -> winner.getKey() != LottoWinnerTable.DEFAULT)
                .map(winner -> String.format(LottoCommonString.FORMAT_WINNER_TABLE_RESULT.getMessage(),
                        winner.getKey().getWinningCondition(),
                        winner.getKey().getWinningStringMoney(),
                        winner.getValue()))
                .collect(Collectors.toList());
    }

    public BigDecimal totalProfit(LottoBuyer lottoBuyer) {
        BigDecimal price = lottoBuyer.getBuyingMoney();
        return this.getTotalEarn()
                .divide(price)
                .multiply(BigDecimal.valueOf(100));
    }

    private BigDecimal getTotalEarn() {
        return winnerCounter.entrySet()
                .stream()
                .map(entry -> {
                    BigDecimal winningMoney = entry.getKey().getWinningMoney();
                    return winningMoney.multiply(BigDecimal.valueOf(entry.getValue()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void addCount(LottoWinnerTable keyToCount) {
        this.winnerCounter.merge(keyToCount, 1, Integer::sum);
    }

    private LottoWinnerCounter() {
        this.winnerCounter = LottoWinnerTable.generateEnumMap();
    }

}
