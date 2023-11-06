package lotto;

import java.util.List;

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

}
