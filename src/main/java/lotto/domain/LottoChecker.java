package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LottoChecker {
    private static final int NONE = 0;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Prize, Integer> result = new HashMap<>();
    private List<Lotto> lottos;
    private long totalPrize;
    private String profitRate;

    public LottoChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initPrize();
    }

    public void initPrize() {
        result.put(Prize.FIRST, NONE);
        result.put(Prize.SECOND, NONE);
        result.put(Prize.THIRD, NONE);
        result.put(Prize.FOURTH, NONE);
        result.put(Prize.FIFTH, NONE);
        result.put(Prize.NONE, NONE);
    }

    public void checkLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
        compareWithWinningNumbers();
        calculateTotalPrize();
        calculateProfitRate();
    }

    public void compareWithWinningNumbers() {
        lottos.forEach(lotto -> {
            long matches = checkWinningNumber(lotto);
            boolean isContainBonus = false;
            if (matches == 5) {
                isContainBonus = checkContainBonusNumber(lotto);
            }
            Prize prize = getPrize(matches, isContainBonus);
            result.put(prize, result.get(prize) + 1);
        });
    }

    public long checkWinningNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.stream()
                .filter(winningNumbers::contains).count();
    }

    public boolean checkContainBonusNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.contains(bonusNumber);
    }

    public Prize getPrize(final long matches, boolean isContainBonus) {
        if (matches == 6) {
            return Prize.FIRST;
        }
        if (matches == 5 && isContainBonus) {
            return Prize.SECOND;
        }
        if (matches == 5) {
            return Prize.THIRD;
        }
        if (matches == 4) {
            return Prize.FOURTH;
        }
        if (matches == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    public void calculateTotalPrize() {
        totalPrize = result.keySet().stream().mapToLong(prize -> prize.money * result.get(prize)).sum();
    }

    public void calculateProfitRate() {
        if (totalPrize == 0) {
            profitRate = "0.0";
            return ;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        double usedMoney = (long) lottos.size() * 1000;
        double profit = (totalPrize / usedMoney) * 100;
        profitRate = decimalFormat.format(profit);
    }

    public long getTotalPrize() {
        return this.totalPrize;
    }

    public String getProfitRate() {
        return this.profitRate;
    }

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(this.result);
    }
}
