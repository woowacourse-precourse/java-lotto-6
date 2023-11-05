package lotto.domain.Controller;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Model.LottoMaker;
import lotto.domain.Model.Prize;
import lotto.domain.View.LottoInputView;
import lotto.domain.View.LottoOutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoMaker lottoMaker;
    private LottoContainer lottoContainer;
    private int cash;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoMaker lottoMaker) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoMaker = lottoMaker;
    }

    public void run() {
        this.cash = lottoInputView.inputCash(); // 금액 입력
        this.lottoContainer = lottoMaker.issue(cash);
        lottoOutputView.printPickedLotto(lottoContainer); // 로또 출력
        this.winningNumbers = lottoInputView.inputWinningNumbers(); // 당첨 번호 입력
        this.bonusNumber = lottoInputView.inputBonusNumber(winningNumbers); // 보너스 번호 입력
        result(); // 최종 결과 계산 및 출력
    }

    private void result() {
        List<Lotto> lottos = this.lottoContainer.getLottos();

        Map<String, Integer> winnings = new HashMap<>();

        for (Lotto lotto : lottos) {
            String rank = judgeWinnings(lotto);
            if (rank != null) {
                winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
            }
        }

        lottoOutputView.printWinnings(winnings, this.cash);
    }

    private String judgeWinnings(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = countMatch(numbers, this.winningNumbers);
        boolean isBonusMatch = numbers.contains(bonusNumber);

        Prize prize = Prize.prizeCount(matchCount, isBonusMatch);
        if (prize != null) {
            return prize.getRank();
        }
        return null;
    }

    private int countMatch(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
