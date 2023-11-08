package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRule;
import lotto.exception.ExceptionMessage;

public class Winning extends LottoRule {
    private List<Integer> numbers;
    private int bonusNumber;

    public Map<Prize, Integer> calcTotalPrize(List<Lotto> lottos) {
        Map<Prize, Integer> totalPrize = Prize.initTotalPrizeMap();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchNumberCount(lotto);
            boolean isMatchBonus = isContainBonusNumber(lotto);
            Prize prize = getPrize(matchCount, isMatchBonus);

            addPrizeCount(totalPrize, prize);
        }
        return totalPrize;
    }

    public double calcRevenueRate(Map<Prize, Integer> totalPrize, int purchaseAmount) {
        List<Prize> prizes = getPrizesByMoreThanOne(totalPrize);
        int totalPrizeAmount = getTotalPrizeAmount(prizes);

        double revenueRate = (double) totalPrizeAmount / purchaseAmount * 100;
        return Math.round(revenueRate * 10) / 10.0;
    }

    public void validateBonus(int bonusNumber) {
        if (isDuplicateBonusNumber(bonusNumber)) {
            ExceptionMessage.BONUS_NUMBER_DUPLICATE.throwException();
        }
        if (isOutOfRange(bonusNumber)) {
            ExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    void addPrizeCount(Map<Prize, Integer> totalPrize, Prize prize) {
        int count = totalPrize.get(prize);
        totalPrize.put(prize, ++count);
    }

    int getMatchNumberCount(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .filter(this.numbers::contains)
                .collect(Collectors.toList())
                .size();
    }

    boolean isContainBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    Prize getPrize(int matchCount, boolean isMatchBonus) {
        if (matchCount == 6) {
            return Prize.SIX_MATCH;
        } else if (matchCount == 5 && isMatchBonus) {
            return Prize.FIVE_MATCH_BONUS;
        } else if (matchCount == 5) {
            return Prize.FIVE_MATCH;
        } else if (matchCount == 4) {
            return Prize.FOUR_MATCH;
        } else if (matchCount == 3) {
            return Prize.THREE_MATCH;
        }
        return Prize.FAIL;
    }

    private List<Prize> getPrizesByMoreThanOne(Map<Prize, Integer> totalPrize) {
        return totalPrize.entrySet().stream()
                .filter(entry -> entry.getValue() >= 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getTotalPrizeAmount(List<Prize> prizes){
        int prizeAmount = 0;

        for (Prize prize : prizes){
            prizeAmount += prize.getPrice();
        }
        return prizeAmount;
    }

    private boolean isDuplicateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
