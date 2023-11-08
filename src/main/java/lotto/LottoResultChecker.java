package lotto;

import java.util.List;
import java.util.function.Predicate;

public class LottoResultChecker {

    final NumberGenerator numberGenerator = new NumberGenerator();
    List<Integer> winningNumbers; // 당첨번호
    int bonusNumber; // 당첨 보너스 번호
    Lotto [] userLottoNumbers; // 사용자가 구매한 번호
    int [] ranks = {0, 0, 0, 0, 0, 0}; // 각 등수의 당첨 개수 ex) ranks[1]은 1등 당첨 개수; rank[0]은 미 당첨 개수
    int reward; // 상금
    String returnRatio; // 수익률

    public LottoResultChecker(Lotto winningLotto, Lotto [] userLotto, int bonusNumber) {
        this.winningNumbers = winningLotto.getNumbers();
        this.userLottoNumbers = userLotto;
        this.bonusNumber = bonusNumber;
    }

    public void checkLottoResult() {
        reward = 0;
        for (Lotto userLottoNumber: userLottoNumbers){
            reward += calculateReward(countMatchNumbers(userLottoNumber));
        }
        returnRatio = calculateReturnRation() + ""; // 수익률을 계산 후 문자열로 변환
    }

    public double countMatchNumbers(Lotto lotto) {
        List<Integer> matchNumbers = winningNumbers.stream()
                .filter(old -> lotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(old)))
                .toList();
        // 일치하는 개수가 6개인데 보너스 번호가 있는 경우 -> 2등
        if (matchNumbers.size() == Rank.FIRST_PLACE.getMatchNumberCount() && hasBonusNumber(matchNumbers)){
            return Rank.SECOND_PLACE.getMatchNumberCount();
        }
        return matchNumbers.size();
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    public int calculateReward(double matchNumberCount) {
        if (matchNumberCount == Rank.FIRST_PLACE.getMatchNumberCount()) {
            ranks[1]++;
            return Rank.FIRST_PLACE.getReward();}
        if (matchNumberCount == Rank.SECOND_PLACE.getMatchNumberCount()) {
            ranks[2]++;
            return Rank.SECOND_PLACE.getReward();
        }
        if (matchNumberCount == Rank.THIRD_PLACE.getMatchNumberCount()) {
            ranks[3]++;
            return Rank.THIRD_PLACE.getReward();}
        if (matchNumberCount == Rank.FOURTH_PLACE.getMatchNumberCount()) {
            ranks[4]++;
            return Rank.FOURTH_PLACE.getReward();
        }
        if (matchNumberCount == Rank.FIFTH_PLACE.getMatchNumberCount()) {
            ranks[5]++;
            return Rank.FIFTH_PLACE.getReward();
        }
        ranks[0]++;
        return Rank.NONE.getReward(); // 매치되는 숫자 개수가 0인 경우
    }

    public double calculateReturnRation() {
        // 계산한 수익률을 소수점 둘째 자리에서 반올림하여 리턴
        return Math.round((reward / (Application.ONE_LOTTO_PRICE * userLottoNumbers.length)) * 100.0) / 100.0;
    }

}
