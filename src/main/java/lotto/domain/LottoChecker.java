package lotto.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LottoChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Prize, Integer> result = new HashMap<>();
    private long totalPrize;
    private String profitRate;

    public LottoChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.initPrize();
    }

    public void initPrize() {
        result.put(Prize.FIRST, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.FIFTH, 0);
        result.put(Prize.NONE, 0);
    }

    public void insertLottos(final List<Lotto> lottoPapers) {
        this.lottos = lottoPapers;
        saveLottosResult();
        calculateTotalPrize();
        calculateProfitRate();
    }

    public void saveLottosResult() {
        lottos.forEach(lotto -> {
            long matches = this.checkWinningNumber(lotto);
            boolean isContainBonus = false;
            if (matches == 5L) {
                isContainBonus = checkContainBonusNumber(lotto);
            }
            Prize prize = this.getPrize(matches, isContainBonus);
            result.put(prize, this.result.get(prize) + 1);
        });
    }

    public long checkWinningNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        long matches = lottoNumbers.stream()
                .filter(this.winningNumbers::contains).count();

        return matches;
    }

    public boolean checkContainBonusNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        boolean isContainBonus = lottoNumbers.contains(this.bonusNumber);

        return isContainBonus;
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

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(this.result);
    }

    public void calculateTotalPrize() {
        long totalPrize = result.keySet().stream().mapToLong(prize -> prize.money * result.get(prize)).sum();
        this.totalPrize = totalPrize;
    }

    public void calculateProfitRate() {
        if (totalPrize == 0) {
            profitRate = "0.0";
            return ;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        double usedMoney = (long) lottos.size() * 1000;
        double profitRate = (this.totalPrize / usedMoney) * 100;
        this.profitRate = decimalFormat.format(profitRate);
    }

    public long getTotalPrize() {
        return this.totalPrize;
    }

    public String getProfitRate() {
        return this.profitRate;
    }
}
