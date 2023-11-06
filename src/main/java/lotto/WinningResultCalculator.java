package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningResultCalculator {
    private final HashMap<LottoData,Integer> lottoData;
    private double totalPrizeMoney;

    public WinningResultCalculator() {
        this.lottoData = new HashMap<>() {{
            put(LottoData.FIRST_PRIZE, 0);
            put(LottoData.SECOND_PRIZE, 0);
            put(LottoData.THIRD_PRIZE, 0);
            put(LottoData.FOURTH_PRIZE, 0);
            put(LottoData.FIFTH_PRIZE, 0);
            put(LottoData.BLANK, 0);
        }};

        totalPrizeMoney = 0;
    }

    public HashMap<LottoData, Integer> getWinningData() {
        return lottoData;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            increaseWinningHistoryType(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void increaseWinningHistoryType(int matchNumber, boolean matchBonus) {
        LottoData prizeType = LottoData.getLottoDataType(matchNumber, matchBonus);
        lottoData.put(prizeType, lottoData.get(prizeType) + 1);
        plusTotalPrizeMoney(prizeType.getPrize());
    }

    private void plusTotalPrizeMoney(int prizeMoney) {
        totalPrizeMoney += prizeMoney;
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String calculateRateOfReturn(int amount) {
        totalPrizeMoney *= 1.0;
        return roundTowDecimalPlaces((totalPrizeMoney / amount) * 100);
    }

    private String roundTowDecimalPlaces(double rate) {
        return String.format("%.1f", rate);
    }
}
