package lotto.domain;

import static lotto.constant.LottoInformation.LOTTO_PRICE;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Prize;

public class LottoCalculator {
    private final int SPECIAL_MATCH = 7;
    private final Lotto winningNumber;
    private final int bonusNumber;
    private final Map<Prize, Integer> result = new LinkedHashMap<>();

    public LottoCalculator(WinningNumbers winningNumbers) {
        this.winningNumber = winningNumbers.getWinningNumber();
        this.bonusNumber = winningNumbers.getBonusNumber();
    }

    public void makePrizeResult(List<Lotto> lottoTickets) {
        initResult();
        for (Lotto oneTicket : lottoTickets) {
            int matchCount = countMatchNumbers(oneTicket);
            Prize prize = Prize.getByMatch(matchCount);

            if (prize != Prize.NONE) {
                result.put(prize, result.get(prize) + 1);
            }
        }
    }

    public void initResult() {
        result.put(Prize.FIFTH, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.FIRST, 0);
        result.put(Prize.NONE, 0);
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                matchCount++;
            }
            if (matchCount == 5 && isContainBonusNumber(lotto)) {
                return SPECIAL_MATCH;
            }
        }
        return matchCount;
    }

    public String calculateProfitRate() {
        int money = calculateTotalSpent();
        long totalPrize = calculateTotalPrize();
        if (totalPrize == 0) {
            return "0.0";
        }
        double profit = ((double) totalPrize / money) * 100;
        profit = Math.round(profit * 10) / 10.0;
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(profit);
    }

    public long calculateTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry ->
                        (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public int calculateTotalSpent() {
        int count = result.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        return count * LOTTO_PRICE;
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
