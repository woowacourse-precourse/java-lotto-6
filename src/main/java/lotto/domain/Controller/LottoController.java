package lotto.domain.Controller;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Model.LottoMaker;
import lotto.domain.Model.Prize;
import lotto.domain.View.LottoView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMaker lottoMaker;
    private LottoContainer lottoContainer;
    private int cash;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController(LottoView lottoView, LottoMaker lottoMaker) {
        this.lottoView = lottoView;
        this.lottoMaker = lottoMaker;
    }

    public void run() {
        this.cash = lottoView.inputCash(); // 금액 입력
        this.lottoContainer = lottoMaker.issue(cash);
        lottoView.printPickedLotto(lottoContainer); // 로또 출력
        this.winningNumbers = lottoView.inputWinningNumbers(); // 당첨 번호 입력
        this.bonusNumber = lottoView.inputBonusNumber(winningNumbers); // 보너스 번호 입력
        result(); // 최종 결과 계산 및 출력
    }

    private void result() {
        List<Lotto> lottos = this.lottoContainer.getLottos();

        Map<String, Integer> winnings = new HashMap<>();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int matchCount = countMatch(numbers, this.winningNumbers);
            boolean isBonusMatch = numbers.contains(bonusNumber);

            Prize prize = Prize.prizeCount(matchCount, isBonusMatch);
            if (prize != null) {
                String rank = prize.getRank();
                winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
            }
        }

        lottoView.printWinnings(winnings, this.cash);
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
