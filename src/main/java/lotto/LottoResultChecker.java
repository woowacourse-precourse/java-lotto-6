package lotto;

import java.util.List;
import java.util.function.Predicate;

public class LottoResultChecker {

    final NumberGenerator numberGenerator = new NumberGenerator();
    List<Integer> winningNumbers; // 당첨번호
    List<Integer> userLottoNumbers; // 사용자가 구매한 번호
    int rank; // 등수
    int reward; // 상금

    public LottoResultChecker(List<Integer> winningNumbers, List<Integer> userLottoNumbers) {
        this.winningNumbers = winningNumbers;
        this.userLottoNumbers = userLottoNumbers;
    }

    public int countMatchNumbers(){
        List<Integer> matchNumbers = winningNumbers.stream()
                .filter(old -> userLottoNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .toList();
        return matchNumbers.size();
    }

}
