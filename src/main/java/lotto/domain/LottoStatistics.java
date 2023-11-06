package lotto.domain;

import lotto.constants.WinningFactor;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final Integer MATCH_UP = 1;
    private static final Integer INIT_VALUE = 0;
    private final EnumMap<WinningFactor, Integer> statistics = new EnumMap<>(WinningFactor.class);
    private Double totalRate = 0.0;

    public LottoStatistics() {
        for (WinningFactor factor : WinningFactor.values()) {
            statistics.put(factor, INIT_VALUE);
        }
    }

    public void calculateLottoMatch(PlayerLottoNumbers playerLottoNumbers, WinningLotto winningLotto) {
        for (Numbers numbers : playerLottoNumbers.getLottoValues()) {
            Integer matchCount = numbers.getMatchCount(winningLotto.getLotto()).intValue();
            Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(winningLotto.getBonusNumber());
            upWinningFactorValue(matchCount, isMatchBonusNumber);
        }
    }

    private void upWinningFactorValue(Integer matchCount, Boolean isMatchBonusNumber) {
        WinningFactor winningFactorByCount = WinningFactor.findWinningFactorByCount(matchCount, isMatchBonusNumber);
        statistics.put(winningFactorByCount, statistics.get(winningFactorByCount) + MATCH_UP);
    }

    public Map<WinningFactor, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void calculateTotalRate(PlayerLottoNumbers playerLottoNumbers) {
        Integer lottosPrice = playerLottoNumbers.getLottosPrice();
        Integer sum = calculateWinningPrice();

        double rate = (double) sum / lottosPrice * 100.0;
        this.totalRate = Math.round(rate * 100.0) / 100.0;
    }

    private Integer calculateWinningPrice() {
        int sum = 0;
        for (Map.Entry<WinningFactor, Integer> entry : statistics.entrySet()) {
            WinningFactor winningFactor = entry.getKey();
            Integer value = entry.getValue();
            sum += winningFactor.getMoney() * value;
        }
        return sum;
    }
}
