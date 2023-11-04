package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoChecker {

    private final List<Integer> WINNING_NUMBERS;
    private final int BONUS_NUMBER;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Prize, Integer> result = new HashMap<>();

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
        for (Lotto lotto : this.lottos) {
            long matches = this.checkWinningNumber(lotto);
            boolean isContainBonus = false;
            if (matches == 5L) {
                isContainBonus = checkContainBonusNumber(lotto);
            }
            Prize prize = this.getPrize(matches, isContainBonus);
            this.result.put(prize, this.result.get(prize) + 1);
        }
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

}
