package lotto;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    private final List<Integer> WINNING_NUMBERS;
    private final int BONUS_NUMBER;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Prize, Integer> result = new HashMap<>();
    private long totalPrize;
    private String profitRate;

    public LottoChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        this.WINNING_NUMBERS = winningNumbers;
        this.BONUS_NUMBER = bonusNumber;
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
    }

    public void saveLottosResult() {
        this.lottos.forEach(lotto -> {
            long matches = this.checkWinningNumber(lotto);
            boolean isContainBonus = false;
            if (matches == 5L) {
                isContainBonus = checkContainBonusNumber(lotto);
            }
            Prize prize = this.getPrize(matches, isContainBonus);
            this.result.put(prize, this.result.get(prize) + 1);
        });
    }

    public long checkWinningNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        long matches = lottoNumbers.stream()
                .filter(this.WINNING_NUMBERS::contains).count();

        return matches;
    }

    public boolean checkContainBonusNumber(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        boolean isContainBonus = lottoNumbers.contains(this.BONUS_NUMBER);

        return isContainBonus;
    }

    public Prize getPrize(final long matches, boolean isContainBonus) {
        if (matches == 6L) {
            return Prize.FIRST;
        }
        if (matches == 5L && isContainBonus) {
            return Prize.SECOND;
        }
        if (matches == 5L) {
            return Prize.THIRD;
        }
        if (matches == 4L) {
            return Prize.FOURTH;
        }
        if (matches == 3L) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    public Map<Prize, Integer> getResult() {
        return this.result;
    }

    public void calculateTotalPrize() {
        long totalPrize = this.result.keySet().stream().mapToLong(prize -> prize.money * this.result.get(prize)).sum();
        this.totalPrize = totalPrize;
    }

    public void calculateProfitRate() {
        if (this.totalPrize == 0) {
            this.profitRate = "0.0";
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
