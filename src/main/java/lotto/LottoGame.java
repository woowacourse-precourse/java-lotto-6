package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottoTickets;
    private final LottoWinningStatistics statistics;

    public LottoGame(int lottoCount) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(lotto);
        }
        this.statistics = new LottoWinningStatistics();
    }

    public void printLottoTickets() {
        // 구현: 발행한 로또 티켓을 출력합니다.
    }

    public void checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        // 구현: 각 로또 티켓 별로 당첨 확인을 합니다.
    }

    public void printStatistics() {
        // 구현: 당첨 통계를 출력합니다.
    }

    public void calculateProfitRate(int purchaseAmount) {
        // 구현: 수익률을 계산하고 출력합니다.
    }
}
