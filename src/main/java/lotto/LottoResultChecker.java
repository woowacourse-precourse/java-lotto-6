package lotto;

import java.util.List;
import java.util.function.Predicate;

public class LottoResultChecker {

    final NumberGenerator numberGenerator = new NumberGenerator();
    List<Integer> winningNumbers; // 당첨번호
    int bonusNumber; // 당첨 보너스 번호
    List<Integer> userLottoNumbers; // 사용자가 구매한 번호
    int rank; // 등수
    String reward; // 상금

    public LottoResultChecker(List<Integer> winningNumbers, List<Integer> userLottoNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.userLottoNumbers = userLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public double countMatchNumbers() {
        List<Integer> matchNumbers = winningNumbers.stream()
                .filter(old -> userLottoNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .toList();
        // 일치하는 개수가 6개인데 보너스 번호가 있는 경우 -> 2등
        if(matchNumbers.size() == Rank.FIRST_PLACE.getMatchNumberCount() && hasBonusNumber(matchNumbers))
            return Rank.SECOND_PLACE.getMatchNumberCount();
        return matchNumbers.size();
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    public String calculateReward(double matchNumberCount) {
        if (matchNumberCount == Rank.FIRST_PLACE.getMatchNumberCount()) return Rank.FIRST_PLACE.getReward();
        if (matchNumberCount == Rank.SECOND_PLACE.getMatchNumberCount()) return Rank.SECOND_PLACE.getReward();
        if (matchNumberCount == Rank.THIRD_PLACE.getMatchNumberCount()) return Rank.THIRD_PLACE.getReward();
        if (matchNumberCount == Rank.FOURTH_PLACE.getMatchNumberCount()) return Rank.FOURTH_PLACE.getReward();
        if (matchNumberCount == Rank.FIFTH_PLACE.getMatchNumberCount()) return Rank.FIFTH_PLACE.getReward();
        return Rank.NONE.getReward(); // 매치되는 숫자 개수가 0인 경우
    }

}
